using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
//using TransiSoftBusiness.BO;
//using TransiSoftBusiness.BOImpl;
//using TransiSoftModel.Model;
using TransiSoftWA.TransiSoftServices;

namespace TransiSoftWA
{
    public partial class ListaCapturas : System.Web.UI.Page
    {
        private CapturaWSClient capturaBO;
        
        private BindingList<captura> capturas;
        private void Page_Init(object sender, EventArgs e)
        {
            capturaBO = new CapturaWSClient();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            CargarCapturas();
        }
        private void CargarCapturas()
        {
            try
            {
                capturas = new BindingList<captura>(capturaBO.listarCapturasTodas());
                GvCapturas.DataSource = capturas;
                GvCapturas.DataBind();
            }
            catch (Exception ex)
            {
                LblMensaje.Text = "Error al cargar las capturas: " + ex.Message;
                LblMensaje.CssClass = "alert alert-danger";
            }
        }
        protected void GvCapturas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            GvCapturas.PageIndex = e.NewPageIndex; // cambia el índice de página
            CargarCapturas(); // recarga los datos
        }
        protected void btnModificar_Click(object sender, EventArgs e)
        {
            /*int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            Empleado empleadoSeleccionado = empleados.Single(x => x.IdPersona == idEmpleado);
            Session["empleado"] = empleadoSeleccionado;
            Response.Redirect("RegistrarEmpleado.aspx?accion=modificar");*/
            int idCaptura = Int32.Parse(((LinkButton)sender).CommandArgument);
            captura capturaSeleccionado = capturas.Single(x => x.id == idCaptura);
            Session["captura"] = capturaSeleccionado;
            Response.Redirect("ModificarCaptura.aspx");
        }

    }
}