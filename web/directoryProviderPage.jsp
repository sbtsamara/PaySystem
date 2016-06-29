<%--
  Created by IntelliJ IDEA.
  User: Vo4ik
  Date: 23.06.2016
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <title>Список поставщиков</title>
    <link rel="stylesheet" type="text/css" href="css/styleEditProvider.css" charset="UTF-8">
    <style type="text/css">
        .tr1{position:absolute;left:30px;WIDTH:1px;margin-top:0px;overflow:hidden;height:90.3%;border-width:1px;}
        .tr2{position:absolute;left:300px;WIDTH:1px;margin-top:0px;overflow:hidden;height:90.3%;border-width:1px;}
        .tr3{position:absolute;left:600px;WIDTH:1px;margin-top:0px;overflow:hidden;height:90.3%;border-width:1px;}
        .t1{float:left;width:30px;text-align:center;height:20px;background-color:#999;color:#FFF}
        .t2{float:left;width:300px;text-align:center;height:20px;background-color:#999;color:#FFF}
        .t3{float:left;width:270px;text-align:center;height:20px;background-color:#999;color:#FFF}
        .select{height:53px;border:0px solid #900; width:600px;font-size: 14px;font-family: Lucida Console;overflow-y:auto;}


        body {font-size:14px;}
        label {float:left; padding-right:10px;}
        .field {clear:both; text-align:right; line-height:25px;}
        .fieldbuttonAdd {clear:both; text-align:center; line-height:25px;}
        .alignment {float:left;}

    </style>
    <script language="JavaScript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" language="JavaScript" >
        var U_Catalog=new fCatalog();
        function fCatalog()
        {
            this.Data= new Array();
        }
        function fCatalogRecord(A_Code,A_Name,A_Cost)
        {
            this.Code=A_Code;
            this.Name=A_Name;
            this.Cost=A_Cost;
        }
        function AS_GetSpace(A_Value,A_Sp)
        {
            var L_Result='';
            for(var L_i=0;L_i<A_Value;L_i++)
                L_Result=L_Result+'&nbsp;';
            return L_Result;
        }
        function AS_Format()
        {
            var L_Arr=new Array(3,33,31);
            var L_Sp=new Array(1,1,1);
            var L_Result='';
            var L_Length=arguments.length;
            var L_Str='';
            for(var L_i=0;L_i<L_Length;L_i++)
            {
                if ((L_i==1)&&(arguments[L_i]==0))
                    arguments[L_i]='';
                if (arguments[L_i].length>L_Arr[L_i])
                    L_Str=arguments[L_i].substr(0,L_Arr[L_i])+'';
                else
                    L_Str=arguments[L_i]+'';
                L_Result=L_Result+L_Str+AS_GetSpace(L_Arr[L_i]-L_Str.length)+AS_GetSpace(L_Sp[L_i]);
            }
            return L_Result;
        }

        function AS_Load()
        {
            var L_i=U_Catalog.Data.length;
            <c:forEach items="${providers}" var="prov" varStatus="s">
                U_Catalog.Data[L_i]=new fCatalogRecord("${prov.providerId}","${prov.providerName}","${prov.providerAddress}");
                U_1=AS_Format(U_Catalog.Data[L_i].Code,U_Catalog.Data[L_i].Name,U_Catalog.Data[L_i].Cost);
                document.getElementById("idOpt"+"${prov.getProviderId()}").innerHTML=U_1;
            </c:forEach>
            document.getElementById("idCatalog").selectedIndex=0;
        }
        // Дизейбл кнопки Добавить без заполненных полей название и адрес
        function check() {
            var inp1 = document.getElementById('inputNameAddProvider'),
            inp2 = document.getElementById('inputAddressAddProvider')
            document.getElementById('buttonAddProvider').disabled = inp1.value && inp2.value ? false : "disabled";
        }
        // Ограничение на ввод (оставил так некрасиво но хоть так)
        function proverka(input) {
            var value = input.value;
            var rep = /[\!\@\#\$\%\^\&\*\(\)\:\;\+\=\>\<\?\-\`\~\'\"\|\/\.\,]/;
            if (rep.test(value))
            {value = value.replace(rep, ''); input.value = value;}
        }

    </script>
</head>
    <body onload="AS_Load()" class="">
        <div id="idAll" style="position:relative;width:800px;border:1px; text-align:left;">
            <div style="border:0px solid #900;" font:9 Arial;>
                <SELECT id="idTL1" class="tr1" size="3" disabled="disabled"></SELECT>
                <SELECT id="idTL2" class="tr2" size="3" disabled="disabled"></SELECT>
                <SELECT id="idTL3" class="tr3" size="3" disabled="disabled"></SELECT>
                <div class="t1">№</div>
                <div class="t2">Поставщик</div>
                <div class="t3">Адрес</div>
            </div>

            <form action="editProviderServlet" method="post">

            <SELECT name="providerSelect" id="idCatalog" class="select" size="20" style="height:auto;background-color:#CCC;" text-align:left;>
                <c:forEach items="${providers}" var="i" varStatus="s">
                    <option value="${i.providerId}" name="providerSelectId" id="idOpt${i.providerId}"></option>
                </c:forEach>
            </SELECT>
                <br><br>
                <div>
                    <%--<a href="#win1" class="button button-green">--%>
                        <input type="submit" class="button button-green" name="Edit_provider" value="Отредактировать" />
                        <%--<button type="sumbit" class="button button-green" onclick="#win1" formaction="">Отредактировать</button>--%>
                    <%--</a>--%>
                    <input type="submit" name="delete_provider" value="Удалить"/>
                </div>
            </form>
        </div>

        <div class="alignment">
        <form action="editProviderServlet" method="post" >
            <div class="field">
                <p>Название:
                    <input type="text" onkeyup="check(); return proverka(this);" name="newProviderName" id="inputNameAddProvider" />
                </p>
            </div>
            <div class="field">
                <p>Адрес:
                    <input type="text" onkeyup="check(); return proverka(this);" name="newProviderAddress" id="inputAddressAddProvider" />
                </p>
            </div>
            <div class="fieldbuttonAdd">
                <input type="submit" name="addNewProvider" id="buttonAddProvider" value="Добавить" disabled="disabled"/>
            </div>
        </form>
        </div>

        <!-- Модальное окно №1 -->
        <a href="#x" class="overlay" id="win1"></a>
        <div class="popup">
            <h1 align="center">Редактиование поставщика</h1>
            <input>Название поставщика</input>
            <br><br>
            <input>Адрес поставщика</input>
            <br><br>
            <a href="#win2" class="button button-green">
                <button type="sumbit" class="button button-green" onclick="#win1">Изменить</button>
            </a>
            <button>Отмена</button>
            <a class="close" title="Закрыть" href="#close"></a>
        </div>
        <!-- Модальное окно №2 -->
        <a href="#x" class="overlay" id="win2"></a>
        <div class="popup">
            <a href="new 2.html" onclick="return true">
                <h2 align="center" color="red">${editProviderResult}</h2>
                <button type="sumbit">Готово</button>
            </a>
            <!-- <a class="close" title="Закрыть" href="#close"></a> -->
        </div>

    </body>
</html>