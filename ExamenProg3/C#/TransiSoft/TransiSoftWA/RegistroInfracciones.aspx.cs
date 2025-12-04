using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TransiSoftWA.TransiSoftServices;
namespace TransiSoftWA
{
    public partial class RegistroInfracciones : System.Web.UI.Page
    {
        private InfraccionWSClient boinfraccion;
        private CapturaWSClient bocaptura;
        private VehiculoWSClient bovehiculo;
        private PropietarioWSClient bopropietario;
        private infraccion infraccion;
        private captura captura;
        private BindingList<infraccion> infraccionList;
        private BindingList<captura> capturas;
        protected void Page_Init(object sender, EventArgs e)
        {
            boinfraccion = new InfraccionWSClient();
            bocaptura = new CapturaWSClient();
            bovehiculo = new VehiculoWSClient();
            bopropietario=new PropietarioWSClient();
            infraccion = new infraccion();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

            //infraccionList =
            //    new BindingList<infraccion>(boinfraccion.listarInfraccionesTodas());
            capturas = new BindingList<captura>(bocaptura.listarCapturasTodas());
        }

        protected void BtnBuscarCaptura_Click(object sender, EventArgs e)
        {
            int id=Int32.Parse(TxtIdCaptura.Text);
            captura=capturas.Single(x => x.id == id);
            
            if (captura != null)
            {
                TextVelocidad.Text = captura.velocidad.ToString();
                TxtFecha.Text = captura.fecha_captura.ToString("yyyy-MM-dd");
                TxtPlaca.Text = captura.placa;

                vehiculo v = bovehiculo.obtenerVehiculoPorPlaca(captura.placa);
                TextMarca.Text = v.marca;
                TextModelo.Text = v.modelo;

                propietario p=bopropietario.obtenerPropietarioPorPlaca(captura.placa);

                TextDni.Text = p.dni;
                TextNombres.Text = p.nombres + p.apellidos;

                Session["capturaSeleccionada"] = captura;
                Session["vehiculoSeleccionado"]= v;
                Session["propietarioSeleccionado"] = p;
            }
        }


        protected void BtnRegistrar_Click(object sender, EventArgs e)
        {
            
            infraccion.limite =Double.Parse(TextLimite.Text);
            infraccion.monto=Double.Parse(TextMonto.Text);
            infraccion.fecha_registro = DateTime.Today;
            infraccion.fecha_registroSpecified = true;
            infraccion.exceso = Double.Parse(TextVelocidad.Text) - infraccion.limite;
            captura = (captura)Session["capturaSeleccionada"];

            infraccion.vehiculo = (vehiculo)Session["vehiculoSeleccionado"];

            infraccion.propietario = (propietario)Session["propietarioSeleccionado"];

            camara cam = new camara();
            cam = captura.camara;
            infraccion.camara = cam;

            //infraccion.captura = new captura();
            //infraccion.captura.velocidad = captura.velocidad;
            //infraccion.captura.placa = captura.placa;
            //infraccion.captura.fecha_captura = captura.fecha_captura;
            infraccion.captura= captura;
            boinfraccion.insertarInfraccion(infraccion);

            Response.Redirect("RegistroInfracciones.aspx");
        }
    }
}