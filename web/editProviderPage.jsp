<%--
  Created by IntelliJ IDEA.
  User: Vo4ik
  Date: 28.06.2016
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Редактирование поставщика</title>
        <style>
            body {font-size:14px;}
            label {float:left; padding-right:10px;}
            .field {clear:both; text-align:right; line-height:25px;}
            .fieldbuttonAdd {clear:both; text-align:center; line-height:25px;}
            .alignment {float:left;}
        </style>
        <script type="text/javascript" charset="utf-8" language="JavaScript" >
            function check() {
                var inp1 = document.getElementById('inputNewNameProvider'),
                inp2 = document.getElementById('inputNewAddressProvider')
                document.getElementById('buttonEditProvider').disabled = inp1.value && inp2.value ? false : "disabled";
            }

            function proverka(input) {
                var value = input.value;
                var rep = /[\!\@\#\$\%\^\&\*\(\)\:\;\+\=\>\<\?\-\`\~\'\"\|\/\.\,]/;
                if (rep.test(value))
                {value = value.replace(rep, ''); input.value = value;}
            }
        </script>
    </head>
    <body>
        <div class="alignment">
            <form action="editProviderServlet" method="post" >
                <div class="field">
                    <p>Новое название:
                        <input type="text" onkeyup="check(); return proverka(this);" name="newProviderName" id="inputNewNameProvider" />
                    </p>
                </div>
                <div class="field">
                    <p>Новый адрес:
                        <input type="text" onkeyup="check(); return proverka(this);" name="newProviderAddress" id="inputNewAddressProvider" />
                    </p>
                </div>
                <div class="fieldbuttonAdd">
                    <input type="submit" name="editProvider" id="buttonEditProvider" value="Изменить" disabled="disabled"/>
                </div>
                <div class="fieldbuttonAdd">
                    <input type="submit" name="exitEditProvider" id="buttonExitEditProvider" value="Отмена"/>
                </div>
                <input type="hidden" name="providerSelect" value="${param.providerSelect}"/>
            </form>
        </div>
    </body>
</html>
