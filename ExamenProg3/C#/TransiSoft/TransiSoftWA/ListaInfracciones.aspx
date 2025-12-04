<%@ Page Title="" Language="C#" MasterPageFile="~/TransiSoft.Master" AutoEventWireup="true" CodeBehind="ListaInfracciones.aspx.cs" Inherits="TransiSoftWA.ListaInfracciones" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_title" runat="server">
    Lista Infracciones
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
    <div class="container mt-4">
        <h2>Lista de Infracciones</h2>
        
        <asp:GridView ID="GvInfracciones" runat="server" CssClass="table table-striped table-bordered" 
                    AutoGenerateColumns="False" ShowHeaderWhenEmpty="True" EmptyDataText="Debe listar infracciones">
            <Columns>
                <asp:BoundField DataField="Conductor.NombreApellidos" HeaderText="Conductor" />
                <asp:BoundField DataField="Vehiculo.Placa" HeaderText="Placa Auto" />
                <asp:BoundField DataField="Infraccion.MontoMulta" HeaderText="Monto Multa" DataFormatString="{0:C}" />
                <asp:BoundField DataField="Fecha" HeaderText="Fecha" DataFormatString="{0:dd/MM/yyyy}" />
            </Columns>
        </asp:GridView>
        <asp:Label ID="LblMensaje" runat="server" Text=""></asp:Label>
    </div>
</asp:Content>
