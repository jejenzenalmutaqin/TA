<%-- 
    Document   : login
    Created on : Mar 16, 2018, 5:59:07 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Forms</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="row">
            <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" style="color: #2aabd2; text-align: center">LOGIN</div>
                    <div class="panel-body">
                        <center>
                            <form:form class="form-horizontal" id="formUser" action="loginUser.htm" method="post" modelAttribute="dto">
                                <fieldset>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color: #2aabd2">Pilih User</label>
                                        <div class="col-md-8">
                                            <form:select path="akses" class="form-control" id="drop" name="#">
                                                <option value="0"  selected="true" disabled="true">- Pilih User -</option>
                                                <option value="1">Akademik</option>
                                                <option value="4">Dosen</option>
                                                <option value="5">Mahasiswa</option>
                                            </form:select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color: #2aabd2">Username</label>
                                        <div class="col-md-8">
                                            <form:input path="username" class="form-control" placeholder="Username" name="username" type="username" autofocus=""/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color: #2aabd2">Password</label>
                                        <div class="col-md-8">
                                            <form:input path="password" class="form-control" placeholder="Password" name="password" type="password" value=""/>
                                        </div>
                                    </div>
                                    <form:hidden path="kduser" value="-"/>
                                    <form:hidden path="nim" value="-"/>
                                    <form:hidden path="nip" value="-"/>
                                    <%--<form:hidden path="keterangan" value="-"/>--%>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" style="color: #2aabd2"></label>
                                        <div class="col-md-8 widget-right">
                                        <input type="submit" class="btn btn-primary form-control"  id="sbm" value="Login" />
                                        </div>
                                        </div>
                                </fieldset>
                            </form:form>
                        </center>
                    </div>
                </div>
            </div><!-- /.col-->
        </div><!-- /.row -->	



        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script>
            !function ($) {
                $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                    $(this).find('em:first').toggleClass("glyphicon-minus");
                });
                $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
            }(window.jQuery);

            $(window).on('resize', function () {
                if ($(window).width() > 768)
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })
        </script>	
    </body>

</html>
