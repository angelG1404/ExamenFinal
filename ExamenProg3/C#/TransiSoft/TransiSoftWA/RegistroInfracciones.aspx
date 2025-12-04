<%@ Page Title="" Language="C#" MasterPageFile="~/TransiSoft.Master" AutoEventWireup="true" CodeBehind="RegistroInfracciones.aspx.cs" Inherits="TransiSoftWA.RegistroInfracciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_title" runat="server">
    Registro Infracciones
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="container mt-4">
        <h2>Registro de Infracciones</h2>

        <div class="row mb-3">
            <div class="col-md-6">
                <label for="TxtIdCaptura">ID Captura:</label>
                <div class="input-group">
                    <asp:TextBox ID="TxtIdCaptura" runat="server" CssClass="form-control"></asp:TextBox>
                    <div class="input-group-append">
                        <asp:Button ID="BtnBuscarCaptura" runat="server" Text="Buscar"
                            CssClass="btn btn-primary" OnClick="BtnBuscarCaptura_Click" />
                    </div>
                </div>
            </div>
        </div>

        <div class="row mb-3">
            
            <div class="col-md-6">
                <label for="LblVelocidad">Velocidad:</label>
                <asp:TextBox ID="TextVelocidad" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="col-md-6">
                <label for="LblFecha">Fecha de Captura:</label>
                <asp:TextBox ID="TxtFecha" runat="server" ReadOnly="true" CssClass="form-control" TextMode="Date"></asp:TextBox>
            </div>
            <h3>Datos de Vehiculo</h3>
            <div class="col-md-6">
                <label for="LblPlaca">Placa:</label>
                <asp:TextBox ID="TxtPlaca" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="col-md-6">
                <label for="LblMarca">Marca:</label>
                <asp:TextBox ID="TextMarca" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="col-md-6">
                <label for="LblModelo">Modelo:</label>
                <asp:TextBox ID="TextModelo" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
            </div>
        </div>

        <div class="row mb-3">
            <h3>Datos de Propietario</h3>
            <div class="col-md-6">
                <label for="LblDni">DNI:</label>
                <asp:TextBox ID="TextDni" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="col-md-6">
                <label for="LblNombres">Nombre Completo:</label>
                <asp:TextBox ID="TextNombres" runat="server" ReadOnly="true" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
        <div class="row mb-3">
            <h3>Datos de Infraccion</h3>
            <div class="col-md-6">
                <label for="LblMonto">Monto:</label>
                <asp:TextBox ID="TextMonto" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
            <div class="col-md-6">
                <label for="LblLimite">Limite:</label>
                <asp:TextBox ID="TextLimite" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <asp:Button ID="BtnRegistrar" runat="server" Text="Registrar Infracción" CssClass="btn btn-success"
                    OnClick="BtnRegistrar_Click" />
                <asp:Label ID="LblMensaje" runat="server" CssClass="ml-3"></asp:Label>
            </div>
        </div>        
    </div>

</asp:Content>
