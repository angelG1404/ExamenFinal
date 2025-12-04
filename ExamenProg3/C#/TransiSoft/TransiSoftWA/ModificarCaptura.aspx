<%@ Page Title="" Language="C#" MasterPageFile="~/TransiSoft.Master" AutoEventWireup="true" CodeBehind="ModificarCaptura.aspx.cs" Inherits="TransiSoftWA.ModificarCaptura" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_title" runat="server">
    Modificar Captura
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    <script src="Scripts/TransiSoft/ModificarCaptura.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>
                    <asp:Label ID="lblTitulo" runat="server" Text="Label"></asp:Label>
                </h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblId" runat="server" CssClass="col-sm-2 col-form-label" Text="ID Captura:"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtId" runat="server" CssClass="form-control" MaxLength="8" onkeypress="soloNumeros(event)"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label CssClass="col-sm-2 form-label" ID="lblPlaca" runat="server" Text="Placa:"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox CssClass="form-control" ID="txtPlaca" runat="server"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblVelocidad" runat="server" Text="Velocidad: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtVelocidad" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label runat="server" Text="Fecha Captura: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <input id="dtpFechaCaptura" class="form-control" type="date" runat="server" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblEstado" runat="server" Text="Ingresar Nuevo Estado: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtEstado" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:LinkButton ID="btnRegresar" runat="server" Text="<i class='fa-solid fa-rotate-left pe-2'></i> Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                <asp:LinkButton ID="btnGuardar" CssClass="float-end btn btn-primary" runat="server" Text="<i class='fa-solid fa-floppy-disk pe-2'></i> Guardar" OnClick="btnGuardar_Click" />
            </div>
        </div>
    </div>
    <div class="modal fade" id="errorModal" tabindex="-1" aria-labelledby="errorModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title" id="errorModalLabel">
                    <i class="fa-solid fa-triangle-exclamation me-2"></i>Mensaje de Error
                </h5>
            </div>
            <div class="modal-body">
                <asp:Label ID="lblMensajeError" runat="server" Text="Label" CssClass="form-text text-danger"></asp:Label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
</asp:Content>
