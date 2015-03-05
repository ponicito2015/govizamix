package pkgMenu;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clsConn implements Serializable{
    ResultSet res=null;
    private Connection con= null;
    Statement st=null;
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost/sistema";
    String userDB="mysql";
    String passDB="Anthony2909";

    public clsConn(){
        conectar();
    }
    public int conectar(){
        try{
            Class.forName(driver);
        }
        catch (ClassNotFoundException e){
            System.out.println("No se pudo cargal el driver :-( "+driver);
			return -1;

        }
        try{
            con=DriverManager.getConnection(url,userDB,passDB);
        }
        catch(SQLException e){
            System.out.println("No se pudo realizar la conexion :-(");
			return -2;
        }
	return 1;
    }

    public String buscarS(String sql){
        try{
            ResultSet r=null;
            st=getCon().createStatement();
            r=st.executeQuery(sql);
            r.next();
            return r.getString(1);
        }
        catch(SQLException e){
            return "-1";
        }
    }

    public String buscarC(String sql, int c){
        try{
            ResultSet r=null;
            st=getCon().createStatement();
            r=st.executeQuery(sql);
            if (r.next());
                return r.getString(c);
        }
        catch(SQLException e){
            return "-1";
        }
    }

    public SQLException insertar(String sql){
        try{
            st=getCon().createStatement();
            st.execute(sql);
            st.close();
            return null;
         }
        catch(SQLException e){
	    return e;
        }
     }

     public ResultSet consultar(String sql){
         try{
            st=getCon().createStatement();
            res= st.executeQuery(sql);
         }
        catch(SQLException e){
            return null;
        }
         return res;
     }

    public int verificar(String sql){
        try{
            st=getCon().createStatement();
            res= st.executeQuery(sql);
            if (res.next())
                return 1;
            st.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return -1;
    }

    public int actualizar(String sql){
        try{
            st=getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            return 1;
         }
        catch(SQLException e){
            System.out.println(e);
        }
        return -1;
    }

    public String getCedula(String kcedula){
        java.util.StringTokenizer stl = new java.util.StringTokenizer(kcedula);
        while (stl.hasMoreTokens()){
        if (stl.nextToken().equals("(")){
                kcedula=stl.nextToken();
            }
        }
        return kcedula;
    }

    public StringBuffer reporte(String tabla, boolean r)
    {
        StringBuffer sb = new StringBuffer();
        try{
            String sql="Select * from "+tabla.toString() + " where estado='a'";
            st=getCon().createStatement();
            res= st.executeQuery(sql);
            int x=1;
            boolean b=true;
            sb.append("<table>");
            while (res.next()){
                if (b==true){
                    ResultSet enc=null;
                    sb.append("<font face=\"Arial, Helvetica, sans-serif\" size=\"9\">");
                    sb.append("<tr>");
                    b=false;
                    x=1;
                    while(res.getMetaData().getColumnCount() > x){
                        sb.append("<td bgcolor=\"#CCCCCC\">");
                        sql="Select * from sis where idsis='" + res.getMetaData().getColumnName(x) + "'";
                        st=getCon().createStatement();
                        enc= st.executeQuery(sql);
                        if (enc.next()){
                            sb.append(enc.getString(3));
                        }
                        sb.append("</td>");
                        x++;
                    }
                    sb.append("<td>");
                    sb.append("");
                    sb.append("</td>");
                    sb.append("</tr>");
                    sb.append("</font>");
                }
                sb.append("<tr>");
                x=1;
                while(res.getMetaData().getColumnCount() > x){
                    sb.append("<td>");
                    sb.append(res.getString(x));
                    sb.append("</td>");
                    x++;
                }
                sb.append("<td>");
                if (r == true){
                    sb.append("<a href=\"#\" onclick=\"Edita('eInteligente.jsp?v="+res.getString(1)+"&c="+res.getMetaData().getColumnName(1)+"&t="+tabla.toString()+"')\"> <img src=\"../images/Editar.png\" width=\"20\" height=\"20\" border=\"0\"/></a>");
                    sb.append("<a href=\"#\" onclick=\"Eliminar('bean/dInteligente.jsp?v="+res.getString(1)+"&c="+res.getMetaData().getColumnName(1)+"&t="+tabla.toString()+"')\"> <img src=\"../images/Borrar.png\" width=\"20\" height=\"20\" border=\"0\"/> </a><br/>");
                }
                sb.append("</td>");
                sb.append("</tr>");
            }
            sb.append("</table>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer reporteSQL(String sql, boolean r)
    {
        StringBuffer sb = new StringBuffer();
        try{
            st=getCon().createStatement();
            res= st.executeQuery(sql);
            int x=1;
            boolean b=true;
            sb.append("<table>");
            while (res.next()){
                if (b==true){
                    ResultSet enc=null;
                    sb.append("<font face=\"Arial, Helvetica, sans-serif\" size=\"9\">");
                    sb.append("<tr>");
                    b=false;
                    x=1;
                    while(res.getMetaData().getColumnCount() > x){
                        sb.append("<td bgcolor=\"#CCCCCC\">");
                        sql="Select * from sis where idsis='" + res.getMetaData().getColumnName(x) + "'";
                        st=getCon().createStatement();
                        enc= st.executeQuery(sql);
                        if (enc.next()){
                            sb.append(enc.getString(3));
                        }
                        sb.append("</td>");
                        x++;
                    }
                    sb.append("<td>");
                    sb.append("");
                    sb.append("</td>");
                    sb.append("</tr>");
                    sb.append("</font>");
                }
                sb.append("<tr>");
                x=1;
                while(res.getMetaData().getColumnCount() > x){
                    sb.append("<td>");
                    sb.append(res.getString(x));
                    sb.append("</td>");
                    x++;
                }
                sb.append("<td>");
                if (r == true){
                    //sb.append("<a href=\"#\" onclick=\"Edita('eInteligente.jsp?v="+res.getString(1)+"&c="+res.getMetaData().getColumnName(1)+"&t="+tabla.toString()+"')\"> <img src=\"../images/Editar.png\" width=\"20\" height=\"20\" border=\"0\"/></a>");
                    //sb.append("<a href=\"#\" onclick=\"Eliminar('bean/dInteligente.jsp?v="+res.getString(1)+"&c="+res.getMetaData().getColumnName(1)+"&t="+tabla.toString()+"')\"> <img src=\"../images/Borrar.png\" width=\"20\" height=\"20\" border=\"0\"/> </a><br/>");
                }
                sb.append("</td>");
                sb.append("</tr>");
            }
            sb.append("</table>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }
public String autoCompletar(String tabla, String nombreCol){
String nombres="";
String sql="Select "+nombreCol+" from "+tabla+"";
try{
ResultSet resC;
st=getCon().createStatement();
resC= st.executeQuery(sql);
while (resC.next()){
nombres+="-"+resC.getString(nombreCol);
}
}catch (SQLException e){
return null;
}
return nombres;
}
   

    public StringBuffer cmbGenera(String tabla, int col)
    {
        StringBuffer sb = new StringBuffer();
        try{
            ResultSet resC=null;
            String sql="Select * from "+tabla.toString();
            st=getCon().createStatement();
            resC= st.executeQuery(sql);
            sb.append("<select name=\""+resC.getMetaData().getColumnName(1)+"\" id=\""+resC.getMetaData().getColumnName(1)+"\"");
            while (resC.next()){
                sb.append("<option value=\"" + resC.getString(1) + "\">" + resC.getString(col) + " </option>");
            }
            sb.append("</select>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer cmbGeneraDif(String s, int col)
    {
        StringBuffer sb = new StringBuffer();
        try{
            ResultSet resC=null;
            st=getCon().createStatement();
            resC= st.executeQuery(s);
            sb.append("<select name=\""+resC.getMetaData().getColumnName(1)+"\" id=\""+resC.getMetaData().getColumnName(1)+"\"");
            while (resC.next()){
                sb.append("<option value=\"" + resC.getString(1) + "\">" + resC.getString(col) + " </option>");
            }
            sb.append("</select>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public String autoComplete(String sql, int cantidad, int key, int c1, int c2, int c3)
    {
        String s = new String();
        try{
            ResultSet resC=null;
            //String sql="Select * from "+tabla.toString();
            st=getCon().createStatement();
            resC= st.executeQuery(sql);
            while (resC.next()){
                switch(cantidad){
                    case 1:{
                        s=s+resC.getString(c1)+ " ( " + resC.getString(key) + " ) -";
                        break;
                    }
                    case 2:{
                        s=s+resC.getString(c1) + " " + resC.getString(c2) + " ( " + resC.getString(key) + " ) -";
                        break;
                    }
                    case 3:{
                        s=s+resC.getString(c1) + " " + resC.getString(c2) + " " + resC.getString(c3) + " ( " + resC.getString(key) + " ) -";
                        break;
                    }
                }

            }
        }
        catch(SQLException e){
           s=e.toString();
           return s;
        }
        return s;
    }

    public StringBuffer cmbGenero()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<select name=\"sexo\"");
        sb.append("<option value=\"Masculino\">Masculino</option>");
        sb.append("<option value=\"Femenino\">Femenino</option>");
        sb.append("</select>");
        return sb;
    }

    public StringBuffer cmbGeneraModulo(String Usu, int col, int c)
    {
        StringBuffer sb = new StringBuffer();
        try{
            ResultSet resC=null;
            String sql="";
            if (c == 1){
                sql="select * from Modulo where id_modulo not in (select id_modulo from configuracion where id_usuario='"+Usu+"')";
            }
            else{
                sql="select * from Modulo where id_modulo in (select id_modulo from configuracion where id_usuario='"+Usu+"')";
            }
            st=getCon().createStatement();
            resC= st.executeQuery(sql);
            sb.append("<select name=\""+resC.getMetaData().getColumnName(1)+"\"");
            while (resC.next()){
                sb.append("<option value=\"" + resC.getString(1) + "\">" + resC.getString(col) + " </option>");
            }
            sb.append("</select>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer editar2(String tabla, String key, String  val)
    {
        StringBuffer sb = new StringBuffer();
        try{
            String sql="Select * from "+tabla.toString() + " where " + key.toString() + " ='" + val.toString() + "'";
            st=getCon().createStatement();
            res= st.executeQuery(sql);
            int x=1; int ban=0; int col=0; int banEnc=0; String tbl="";
            if (res.next()){
                sb.append("<div id=\"formulario\">");
                sb.append("<form method=\"post\" action=\"bean/m"+tabla.toString()+".jsp\">");
                sb.append("<table>");
                ResultSet enc=null;
                while(res.getMetaData().getColumnCount() > x){
                    sb.append("<tr>");
                    sb.append("<td>");
                    sql="Select * from sis where idsis='" + res.getMetaData().getColumnName(x) + "'";
                    st=getCon().createStatement();
                    enc=st.executeQuery(sql);
                    if (enc.next()){
                        sb.append(enc.getString(2));
                        if (enc.getString(3).equals("s")){
                            ban=1;
                            col=Integer.parseInt(enc.getString(4).toString());
                            tbl=enc.getString(5).toString();
                        }
                    }
                    sb.append("</td>");
                    sb.append("<td>");
                    banEnc++;
                    if (ban == 1 && banEnc != 1){
                        sb.append(res.getString(x) + " ");
                        sb.append(cmbGenera(tbl, col));

                    }
                    else{
                        sb.append("<INPUT type\"text\" name=\"" + res.getMetaData().getColumnName(x) + "\" value=\"" + res.getString(x) + "\" />");
                    }
                    ban=0;
                    sb.append("</td>");
                    sb.append("</tr>");
                    x++;
                }
                sb.append("<tr>");
                sb.append("<td>");
                sb.append("<input name=\"btnModificar\" type=\"submit\" id=\"btnModificar\" value=\"Modificar\" /> ");
                sb.append("</td>");
                sb.append("</tr>");
                sb.append("</table>");
                sb.append("</form>");
                sb.append("</div>");
            }
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer editar(String tabla, String key, String  val)
    {
        String cab = encFecha().toString();
        StringBuffer sb = new StringBuffer();
        sb.append(cab);
        sb.append("<style type=\"text/css\"> ");
        sb.append("<!-- ");
        sb.append("#form1 input { ");
	sb.append("border-top-style: solid; ");
	sb.append("border-right-style: solid; ");
	sb.append("border-bottom-style: solid; ");
	sb.append("border-left-style: solid; ");
        sb.append("} ");
        sb.append(".Estilo1 { ");
	sb.append("font-family: Arial, Helvetica, sans-serif; ");
	sb.append("font-size: 14px; ");
        sb.append("text-align: left; ");
        sb.append("} ");
        sb.append("--> ");
        sb.append("</style> ");
        try{
            String sql="Select * from sis where tabla='"+tabla.toString() + "' order by conse";
            st=getCon().createStatement();
            res=st.executeQuery(sql);
            sb.append("<tr>");
             int x=1; int col=0;String tbl="";
            //sb.append(""+sql);
            sb.append("<form id=\"form1\" method=\"post\" action=\"bean/m"+tabla.toString()+".jsp\">");
            sb.append("<table>");
            ResultSet enc=null;
            int colunmas=0;
            int len=0;
            int tam=0;
            sb.append("<tr>");
            sb.append("<td>");
            sb.append("<div align=\"right\"> <span class=\"Estilo1\">Código:</span></div>");
            sb.append("<td>");
            String s="Select * from "+tabla.toString() + " where id_" + tabla + " ='" + val.toString() + "'";
            sb.append("<INPUT type=\"text\" name=\"id_" + tabla + "\" size=\"10\" maxlength=\"10\" value=\""+buscarS(s)+"\"/>");
            sb.append("</td>");
            sb.append("</td>");
            sb.append("</tr>");
            sb.append("<tr>");
            while(res.next()){
                //if (colunmas>=2)
                //    sb.append("<tr>");
                len=res.getInt(7);
                tam=12;
                if (len <= 12)
                    tam=12;
                if (len > 12 && len <24)
                    tam=24;
                if (len > 24 && len <54)
                    tam=40;
                if (len > 54)
                    tam=60;

                sb.append("<td>");
                sb.append("<div align=\"right\"> <span class=\"Estilo1\">"+res.getString(3)+":</span></div>");
                sb.append("</td>");
                if (tam==60){
                    sb.append("<td colspan=\"3\">");
                    //sb.append("<td>");
                }
                else{
                    if (tam==40){
                        sb.append("<td colspan=\"3\">");
                    }
                    else{
                        sb.append("<td width=\""+(tam+5)+"\">");
                    }
                }
                // Generador de Opciones Especiales
                if (res.getString(4).equals("s")){
                    col=Integer.parseInt(res.getString(5).toString());
                    tbl=res.getString(8).toString();
                    sb.append(cmbGenera(tbl, col));
                }
                else{
                    if (res.getString(4).equals("f")){
                        sb.append("<div class=\"demo\"><input type=\"text\" id=\"datepicker\" "+ "\" name=\"" + res.getString(2) + "\" size=\""+tam+"\" ></div>");
                    }
                    else{
                        if (res.getString(4).equals("x")){
                            sb.append(cmbGenero());
                        }
                        else{
                            s="Select "+res.getString(2)+" from "+tabla.toString() + " where id_" + tabla + " ='"+val.toString()+"'";
                            sb.append("<INPUT type=\"text\" name=\"" + res.getString(2) + "\" size=\""+tam+"\" maxlength=\""+len+"\" value=\""+buscarS(s)+"\"/>");
                        }
                    }
                }
                sb.append("</td>");
                if (tam==12 || tam==24)
                      colunmas++;
                if (tam==60 || tam==40)
                      colunmas+=2;
                if (colunmas>=2){
                    sb.append("</tr>");
                    colunmas=0;
                }
                x++;
            }
            sb.append("<tr>");
            sb.append("<td>");
            sb.append("<input name=\"btnModificar\" type=\"submit\" id=\"btnModificar\" value=\"Modificar\"/>");
            sb.append("</td>");
            sb.append("</tr>");
            sb.append("</table>");
            sb.append("</form>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer generaInsertar(String tabla)
    {
        String cab = encFecha().toString();
        StringBuffer sb = new StringBuffer();
        sb.append(cab);
        sb.append("<script language=\"Javascript\" src=\"../../js/jq132/jquery-1.3.2.js\"></script>");
        sb.append("<script type=\"text/javascript\" src=\"../../js/form/jquery.validate.js\"></script>");
        sb.append("<style type=\"text/css\"> ");
        sb.append("<!-- ");
        sb.append("#form1 input { ");
	sb.append("border-top-style: solid; ");
	sb.append("border-right-style: solid; ");
	sb.append("border-bottom-style: solid; ");
	sb.append("border-left-style: solid; ");
        sb.append("}");
        sb.append(".Estilo1 {");
	sb.append("font-family: Arial, Helvetica, sans-serif;");
	sb.append("font-size: 14px;");
        sb.append("text-align: left;");
        sb.append("}");
        sb.append("-->");
	sb.append("* { font-family: Verdana; font-size: 96%; }");
	sb.append("label { width: 10em; float: left; }");
	sb.append("label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }");
	sb.append("p { clear: both; }");
	sb.append(".submit { margin-left: 12em; }");
	sb.append("em { font-weight: bold; padding-right: 1em; vertical-align: top; }");
        sb.append("</style> ");
        sb.append("<script type=\"text/javascript\">");
        sb.append("$(document).ready(function(){");
        sb.append("$(\"#form\").validate();");
        sb.append("});");
        sb.append("</script>");
        try{
            String sql="Select * from sis where tabla='"+tabla.toString() + "' order by conse";
            st=getCon().createStatement();
            res=st.executeQuery(sql);
            sb.append("<tr>");
             int x=1; int col=0;String tbl="";
            //sb.append(""+sql);
            sb.append("<form id=\"form\" name=\"form\" method=\"post\" action=\"i"+tabla.toString()+".jsp\">");
            sb.append("<table>");
            ResultSet enc=null;
            int colunmas=0;
            int len=0;
            int tam=0;
            sb.append("<tr>");
            sb.append("<td>");
            sb.append("<div align=\"right\"> <span class=\"Estilo1\">Código:</span></div>");
            sb.append("<td>");
            sb.append("<INPUT type=\"text\" name=\"id_" + tabla + "\" size=\"10\" maxlength=\"10\" class=\"required\"/>");
            sb.append("</td>");
            sb.append("</td>");
            sb.append("</tr>");
            sb.append("<tr>");
            while(res.next()){
                len=res.getInt(7);
                tam=12;
                if (len <= 12)
                    tam=12;
                if (len > 12 && len <24)
                    tam=24;
                if (len > 24 && len <54)
                    tam=40;
                if (len > 54)
                    tam=60;

                sb.append("<td>");
                sb.append("<div align=\"right\"> <span class=\"Estilo1\">"+res.getString(3)+":</span></div>");
                sb.append("</td>");
                if (tam==60){
                    sb.append("<td colspan=\"3\">");
                }
                else{
                    if (tam==40){
                        sb.append("<td colspan=\"3\">");
                    }
                    else{
                        sb.append("<td width=\""+(tam+5)+"\">");
                    }
                }
                // Generador de Opciones Especiales
                if (res.getString(4).equals("s")){
                    col=Integer.parseInt(res.getString(5).toString());
                    tbl=res.getString(8).toString();
                    sb.append(cmbGenera(tbl, col));
                }
                else{
                    if (res.getString(4).equals("f")){
                        sb.append("<div class=\"demo\"><input type=\"text\" id=\"datepicker\" "+ "\" name=\"" + res.getString(2) + "\" size=\""+tam+"\" class=\"date\"></div>");
                    }
                    else{
                        if (res.getString(4).equals("x")){
                            sb.append(cmbGenero());
                        }
                        else{
                            sb.append("<INPUT type=\"text\" name=\"" + res.getString(2) + "\" size=\""+tam+"\" maxlength=\""+len+"\" class=\"required\"/>");
                        }
                    }
                }
                sb.append("</td>");
                if (tam==12 || tam==24)
                      colunmas++;
                if (tam==60 || tam==40)
                      colunmas+=2;
                if (colunmas>=2){
                    sb.append("</tr>");
                    colunmas=0;
                }
                x++;
            }
            sb.append("<tr>");
            sb.append("<td>");
            sb.append("<input name=\"btnInsertar\" type=\"submit\" id=\"btnInsertar\" value=\"Insertar\" /> ");
            sb.append("</td>");
            sb.append("</tr>");
            sb.append("</table>");
            sb.append("</form>");
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public void cerrar(){
        try{
            getCon().close();
        }
	    catch(SQLException e){
            System.out.println(e);
        }
    }

    public StringBuffer encFecha(){
        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\" src=\"../js/jq132/jquery-1.3.2.js\"></script>");
	sb.append("<script type=\"text/javascript\" src=\"../js/jq132/ui/development-bundle/ui/ui.core.js\"></script>");
	sb.append("<script type=\"text/javascript\" src=\"../js/jq132/ui/development-bundle/ui/ui.datepicker.js\"></script>");
	sb.append("<link type=\"text/css\" href=\"../js/jq132/ui/css/ui-darkness/jquery-ui-1.7.2.custom.css\" rel=\"stylesheet\" />");
	sb.append("<script type=\"text/javascript\">");
        sb.append("$(function() {");
	sb.append("	$(\"#datepicker\").datepicker($.datepicker.regional['ES']);");
	sb.append("});");
	sb.append("</script>");
        return sb;
    }

    public String getJSON(String sql, int columnas){
        String jsonResult="";
        int col=columnas;
        try {
            JSon.JQGridJSONModel json = new JSon.JQGridJSONModel();
            java.util.List<JSon.JQGridRow> rows = new java.util.ArrayList<JSon.JQGridRow>();
            JSon.JQGridRow row = new JSon.JQGridRow();
            java.util.List<String> cells = new java.util.ArrayList<String>();
            st = getCon().createStatement();
            res = st.executeQuery(sql);
            int y = 1;
            while (res.next()) {
                cells = new java.util.ArrayList<String>();
                row = new JSon.JQGridRow();
                //row.setId(Integer.parseInt(res.getString(0)));
                row.setId(y);
                col=1;
                while (col<=columnas){
                    cells.add(res.getString(col));
                    col++;
                }
                row.setCell(cells);
                rows.add(row);
                y++;
            }
            json.setPage("1");
            json.setRecords(y);
            json.setTotal("+"+(y<=10?1:2)+"");
            json.setRows(rows);
            flexjson.JSONSerializer serializer = new flexjson.JSONSerializer();
            jsonResult = serializer.exclude("*.class").deepSerialize(json);

        } catch (SQLException ex) {
            Logger.getLogger(clsConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonResult;
     }

    public String getJSONCols(String sql, String cuales){
        String jsonResult="";
        java.util.StringTokenizer cols;
        try {
            JSon.JQGridJSONModel json = new JSon.JQGridJSONModel();
            java.util.List<JSon.JQGridRow> rows = new java.util.ArrayList<JSon.JQGridRow>();
            JSon.JQGridRow row = new JSon.JQGridRow();
            java.util.List<String> cells = new java.util.ArrayList<String>();
            st = getCon().createStatement();
            res = st.executeQuery(sql);
            int y = 1;
            while (res.next()) {
                cells = new java.util.ArrayList<String>();
                row = new JSon.JQGridRow();
                //row.setId(Integer.parseInt(res.getString(0)));
                row.setId(y);
                cols=new java.util.StringTokenizer(cuales, ";");
                while (cols.hasMoreTokens()){
                    cells.add(res.getString(Integer.parseInt(cols.nextToken())));
                }
                row.setCell(cells);
                rows.add(row);
                y++;
            }
            json.setPage("1");
            json.setRecords(y);
            json.setTotal("+"+(y<=10?1:2)+"");
            json.setRows(rows);
            flexjson.JSONSerializer serializer = new flexjson.JSONSerializer();
            jsonResult = serializer.exclude("*.class").deepSerialize(json);

        } catch (SQLException ex) {
            Logger.getLogger(clsConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonResult;
     }

public StringBuffer Lista(String tabla, int col)
    {
        StringBuffer sb = new StringBuffer();
        try{
            ResultSet resC=null;
            String sql="Select * from "+tabla.toString();
            st=getCon().createStatement();
            resC= st.executeQuery(sql);
            while (resC.next()){
                sb.append(" *" + resC.getString(col) + "<br>");
            }
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer ListaModulos(String Usuario, int col)
    {
        StringBuffer sb = new StringBuffer();
        try{
            ResultSet resC=null;
            String sql="select * from Modulo where id_modulo in (select id_modulo from configuracion where id_usuario='"+Usuario+"')";
            st=getCon().createStatement();
            resC= st.executeQuery(sql);
            while (resC.next()){
                sb.append(" *" + resC.getString(col) + "<br>");
            }
        }
        catch(SQLException e){
           sb.append(e.toString());
           return sb;
        }
        return sb;
    }

    public StringBuffer getMeses(){
        StringBuffer sb = new StringBuffer();
        sb.append("<select name=\"mes\">");
        sb.append("<option value=\"01\">Enero</option>");
        sb.append("<option value=\"02\">Febrero</option>");
        sb.append("<option value=\"03\">Marzo</option>");
        sb.append("<option value=\"04\">Abril</option>");
        sb.append("<option value=\"05\">Mayo</option>");
        sb.append("<option value=\"06\">Junio</option>");
        sb.append("<option value=\"07\">Julio</option>");
        sb.append("<option value=\"08\">Agosto</option>");
        sb.append("<option value=\"09\">Septiembre</option>");
        sb.append("<option value=\"10\">Octubre</option>");
        sb.append("<option value=\"11\">Noviembre</option>");
        sb.append("<option value=\"12\">Diciembre</option>");
        sb.append("</select>");
        return sb;
    }

    public StringBuffer getAnyos(){
        StringBuffer sb = new StringBuffer();
        sb.append("<select name=\"anyo\">");
        sb.append("<option value=\"2010\">2010</option>");
        sb.append("<option value=\"2011\">2011</option>");
        sb.append("<option value=\"2012\">2012</option>");
        sb.append("</select>");
        return sb;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }
}
