<%-- 
    Document   : mhs_editdataalumni
    Created on : Mar 17, 2018, 12:54:36 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>





<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MONITORING TA/SKRIPSI</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="js/lumino.glyphs.js"></script>

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>


        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span>APLIKASI MONITORING PENYUSUNAN TUGAS AKHIR/SKRIPSI</span> UNIVERSITAS NASIONAL PASIM</a>
                    <ul class="user-menu">
                        <li class="dropdown pull-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>${dto.namamahasiswa}<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
                                <li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
                                <li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </div><!-- /.container-fluid -->
        </nav>
        <!--//////////////////////////////// menu bar samping kiri //////////////////////////////	-->
        <div id="sidebar-collapse" class="col-sm-7 col-lg-2 sidebar">

            <c:url var="panggilProfil" value="/mhs_profil.htm">
                <c:param name="nim" value="${dto.nim}" />
            </c:url>
            <c:url var="panggilNotif" value="/mhs_notifikasi.htm">
                <c:param name="nim" value="${dto.nim}" />
            </c:url>
            <c:url var="panggilBerandaAlumni" value="/berandaalumni.htm">
                <c:param name="nim" value="${dto.nim}" />
            </c:url>
            <c:url var="panggilIndex" value="/mhs_index.htm">
                <c:param name="nim" value="${dto.nim}" />
            </c:url>
            <ul class="nav menu">

                <li><a href="${panggilIndex}"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home Mahasiswa</a></li>
                <li><a href="${panggilProfil}"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Profil</a></li>
                <li><a href="${panggilNotif}"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Notifikasi</a></li>
                <li class="active"><a href="${panggilBerandaAlumni}"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Beranda Alumni</a></li>
                <li role="presentation" class="divider"></li>

            </ul>

        </div><!--/.sidebar-->
        <!--        begin-content-->
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="akd_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Update Data ALumni</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Update Data Alumni</h1>

                </div>
            </div><!--/.row-->

            <center>
                <!--/.row-->
                <div class="row">
                    <!-- /////////////////////////////////////////////////////////////-->
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"> Form Edit Data Alumni</div>
                            <div class="panel-body">
                                <c:set var="nimTampung" value="${dto.nim}"/>
                                <form:form class="form-horizontal" id="formEditAlumni" action="editAlumniMhs.htm" method="post" modelAttribute="alumniDto" enctype="multipart/form-data">
                                    <form:hidden path="integritas" value="${alumniDto.integritas}"/>
                                    <form:hidden path="keahlian" value="${alumniDto.keahlian}"/>
                                    <form:hidden path="inggris" value="${alumniDto.inggris}"/>
                                    <form:hidden path="teknologi" value="${alumniDto.teknologi}"/>
                                    <form:hidden path="komunikasi" value="${alumniDto.komunikasi}"/>
                                    <form:hidden path="kerjasama" value="${alumniDto.kerjasama}"/>
                                    <form:hidden path="pengembangan" value="${alumniDto.pengembangan}"/>
                                    <form:hidden path="kdalumni" value="${alumniDto.kdalumni}" />
                                    <form:hidden path="tampungannim" value="${nimTampung}" />
                                    <%--<form:hidden path="integritas" value="${dto.nim}" />--%>
                                    <fieldset>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >NIM</label>
                                            <div class="col-md-9">
                                                <form:input path="nim" value="${alumniDto.nim}" id="txnim" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Kode Kelulusan</label>
                                            <div class="col-md-9">
                                                <form:input path="kdkelulusan" value="${alumniDto.kdkelulusan}" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Mulai Bekerja</label>
                                            <div class="col-md-9">
                                                <form:input path="tglmulaikerja" id="tg_mulaikerja" value="${alumniDto.tglmulaikerja}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Perusahaan</label>
                                            <div class="col-md-9">
                                                <form:input path="perusahaan" value="${alumniDto.perusahaan}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Email Perusahaan</label>
                                            <div class="col-md-9">
                                                <form:input path="emailperusahaan" value="${alumniDto.emailperusahaan}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Alamat Perusahaan</label>
                                            <div class="col-md-9">
                                                <form:input path="alamatperusahaan" value="${alumniDto.alamatperusahaan}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Daerah Kerja</label>
                                            <div class="col-md-9">
                                                <form:input path="daerahkerja" value="${alumniDto.daerahkerja}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group" value="${alumniDto.sektor}">
                                            <label class="col-md-3 control-label" >Sektor</label>
                                            <div class="col-md-2">
                                                <form:radiobutton path="sektor" value="bumn" class="form-control"/>BUMN
                                            </div>
                                            <div class="col-md-2">
                                                <form:radiobutton path="sektor" value="swasta" class="form-control"/>Swasta
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Profesi</label>
                                            <div class="col-md-9">
                                                <form:input path="profesi"  value="${alumniDto.profesi}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Testimoni</label>
                                            <div class="col-md-9">
                                                <form:input path="testimoni" value="${alumniDto.testimoni}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Photo</label>
                                            <div class="col-md-9">
                                                <form:input path="foto" id="namafoto" value="${alumniDto.foto}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <script>
                                            function isi()
                                            {
                                                //                                             document.getElementById('file').value;
                                                //                                            alert("haiiii : " + document.getElementById('file').value);
                                                var files = document.getElementById("file").files;

                                                for (var i = 0; i < files.length; i++)
                                                {
                                                    document.getElementById('namafoto').value = files[i].name;
                                                }
                                            }

                                        </script>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Pilih Photo</label>
                                            <div class="col-md-2">
                                                <form:input type="file" id="file" path="file" onchange="isi()" />                        
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12 widget-right">
                                                <input type="submit" class="btn btn-primary btn-md pull-right"  id="sbm" value="Edit" />
                                            </div>
                                        </div>
                                    </fieldset>
                                </form:form>


                                <script>
                                    $(document).ready(function () {
                                    });
                                </script>
                            </div>
                        </div>
                    </div><!--/.col
                                            </div>
                    <!--                        ////////////////////////////////////////-->







            </center>



        </div>	<!--/.main-->



    </body>

</html>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/chart.min.js"></script>
<script src="js/chart-data.js"></script>
<script src="js/easypiechart.js"></script>
<script src="js/easypiechart-data.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
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

                                    var jQuery_1_11_1 = $.noConflict(true);
                                    jQuery_1_11_1(document).ready(function () {
                                        jQuery_1_11_1("#sbm").click(function (evt) { //id tombol submit
                                            evt.preventDefault();
                                            var validate = jQuery_1_11_1('#formTambahProposal').validationEngine('validate'); // id form
                                            if (validate) {
                                                jQuery_1_11_1("#formTambahProposal").submit();
                                            } else {
                                                return false;
                                            }
                                        });

                                    });



                                    $(function () {
//$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
                                        $("#tg_ls").datepicker();

                                    });
                                    $(function () {
//$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
                                        $("#tg_awal").datepicker();

                                    });
                                    $(function () {
//$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
                                        $("#tg_last").datepicker();

                                    });
                                    $(function () {
//$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
                                        $("#tg_serah").datepicker();

                                    });

//    $("#txnim").focusout(function () {// id asal
//                var nim = $('#txnim').val();
//                $.ajax({
//                    type: "POST",
//                    url: "otomatisDataSiswa1.htm",
//                    data: "nim"+nim,
//                    success: function (response) {
//                        $("#txnama").val(response);// id yang dituju
//                    },
//                    error: function (e) {
//                        alert('Error: ' + e);
//                    }
//                });
//            });




</script>
