<%@ Page Title="" Language="C#" MasterPageFile="~/TransiSoft.Master" AutoEventWireup="true" CodeBehind="ListaCapturas.aspx.cs" Inherits="TransiSoftWA.ListaCapturas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cph_title" runat="server">
    Lista Capturas
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cph_Scripts" runat="server">
    
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cph_Contenido" runat="server">
     <div class="container mt-4">
     <h2>Lista de Capturas</h2>
     
     <asp:GridView ID="GvCapturas" runat="server" CssClass="table table-striped table-bordered" 
                 AutoGenerateColumns="False" ShowHeaderWhenEmpty="True" EmptyDataText="Debe listar capturas"
            AllowPaging="True" PageSize ="7" OnPageIndexChanging="GvCapturas_PageIndexChanging">
         <Columns>
             <asp:BoundField DataField="Id" HeaderText="ID" />
             <asp:BoundField DataField="Placa" HeaderText="Placa Auto" />
             <asp:BoundField DataField="Velocidad" HeaderText="Velocidad"/>
             <asp:BoundField DataField="Fecha_captura" HeaderText="Fecha" DataFormatString="{0:dd-MMMM-yyyy}" HtmlEncode="false"  />
             <asp:BoundField DataField="Estado" HeaderText="Estado" />
             <asp:TemplateField>
                 <ItemTemplate>
                     <asp:LinkButton runat="server" Text="<i class='fa-solid fa-edit'></i> ModificarEstado" CssClass="btn btn-warning" OnClick="btnModificar_Click" CommandArgument='<%# Eval("Id")%>' />
                 </ItemTemplate>
             </asp:TemplateField>
         </Columns>
     </asp:GridView>
     <asp:Label ID="LblMensaje" runat="server" Text=""></asp:Label>
 </div>

</asp:Content>
