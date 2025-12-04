using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TransiSoftWA.TransiSoftServices;
//using TransiSoftBusiness.BO;
//using TransiSoftBusiness.BOImpl;
//using TransiSoftModel.Model;

namespace TransiSoftWA
{
    public partial class ModificarCaptura : System.Web.UI.Page
    {
        private captura captura;
        private CapturaWSClient bocaptura;
        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Modificar Captura";
            //estado = Estado.Modificar;
            captura = (captura)Session["captura"];
            if (!IsPostBack)
                AsignarValores();
        }
        public void AsignarValores()
        {
            txtId.Text = captura.id.ToString();
            txtPlaca.Text = captura.placa;
            txtVelocidad.Text = captura.velocidad.ToString();
            dtpFechaCaptura.Value = captura.fecha_captura.ToString("yyyy-MM-dd");
            txtEstado.Text = captura.estado;
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListaCapturas.aspx");
        }
        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            bocaptura = new CapturaWSClient();

            captura.id = Int32.Parse(txtId.Text);
            captura.placa = txtPlaca.Text;
            captura.velocidad = Double.Parse(txtId.Text);
           // try
            
                captura.fecha_captura = DateTime.Parse(dtpFechaCaptura.Value);
            /*}
            catch (Exception ex)
            {
                mostrarMensajeError("Debe elegir una fecha de nacimiento.");
                return;
            }*/
            string nuevoEstado=txtEstado.Text;
            try
            {
                //bocaptura.ModificarEstadoCaptura(nuevoEstado,captura);
            }
            catch (Exception ex)
            {
                lblMensajeError.Text = ex.Message;
                string script = "mostrarModalError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "modalError", script, true);
                return;
            }
             
            Response.Redirect("ListaCapturas.aspx");
        }
    }
}