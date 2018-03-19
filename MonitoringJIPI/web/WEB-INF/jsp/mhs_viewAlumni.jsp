<%-- 
    Document   : mhs_viewAlumni
    Created on : Mar 18, 2018, 11:44:48 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Akademik <span class="caret"></span></a>
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
                    <li class="active">Detail ALumni</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Detail Alumni</h1>

                </div>
            </div><!--/.row-->

            <center>
                <div class="row">
                    <div class="col-lg-5">
                        <c:forEach var="listAlumni" items="${listDto}"> 
                            <fieldset class="h">
                                <table>
                                    <tr>
                                        <td rowspan="7">
                                            <img src="img/${listAlumni.foto}" width="350px" height="420px"/>
                                        </td>
                                        <td>&nbsp;&nbsp;&nbsp;</td>
                                        <td colspan="4" style="text-align: center; background-color: gray;color: orange"><b>Data Profil Pribadi</b></td>
                                        <td></td>
                                        <td></td>

                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td><b>NIM</b></td>
                                        <td>&nbsp;:&nbsp;&nbsp;</td>
                                        <td><c:out value="${listAlumni.nim}"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.</c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Nama Lengkap</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.namamahasiswa}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Tempat, Tanggal Lahir</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.tempatlahir} , ${listAlumni.tgllahir}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Fakultas</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.kdfakultas} - ${listAlumni.namafakultas}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Jurusan</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.kdjurusan} - ${listAlumni.namajurusan}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Daerah Asal</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.daerahasal}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td rowspan="7">
                                            </td><td></td>
                                            <td colspan="4" style="text-align: center; background-color: gray;color: orange"><b>Data Pekerjaan</b></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Daerah Kerja</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.daerahkerja}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Nama Perusahaan</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.perusahaan}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Alamat Perusahaan</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.alamatperusahaan}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Sektor</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.sektor}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Profesi</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.profesi}"></c:out></td>
                                        </tr>
                                        <tr>
                                            <td></td><td></td>
                                            <td><b>Testimoni</b></td>
                                            <td>&nbsp;:&nbsp;&nbsp;</td>
                                            <td><c:out value="${listAlumni.testimoni}"></c:out></td>
                                        </tr>
                                        
                                    </table>
                                </fieldset>
                        </c:forEach>


                        <h4 class="page-header"> </h4>

                    </div>
                </div><!--/.row-->
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
