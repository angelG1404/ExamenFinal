using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TransiSoftWA.TransiSoftServices;
//using TransiSoftBusiness.BO;
//using TransiSoftBusiness.BOImpl;
//using TransiSoftModel.Model;

namespace TransiSoftWA
{
    public partial class ListaInfracciones : System.Web.UI.Page
    {
        private InfraccionWSClient infraccionBO;
        private void Page_Init(object sender, EventArgs e)
        {
            infraccionBO = new InfraccionWSClient();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            CargarInfracciones();

        }
        private void CargarInfracciones()
        {
            try
            {
                BindingList<infraccion> infracciones =
                    new BindingList<infraccion>(infraccionBO.listarInfraccionesTodas());
                GvInfracciones.DataSource = infracciones;
                GvInfracciones.DataBind();
            }
            catch (Exception ex)
            {
                LblMensaje.Text = "Error al cargar las infracciones: " + ex.Message;
                LblMensaje.CssClass = "alert alert-danger";
            }
        }
    }
}