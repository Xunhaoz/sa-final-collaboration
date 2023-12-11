<%@ page import="com.example.front.app.Course" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.example.front.app.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/audio-waves.png" type="image/x-icon">
    <title>VoiceMaster</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%
        Course course = (Course) request.getAttribute("course");
        JSONArray audio = (JSONArray) request.getAttribute("audio");
        JSONArray score = (JSONArray) request.getAttribute("score");
    %>
    <!-- Sidebar -->
    <ul style="background-color: #85a59e" class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas">
                    <img style="width: 30px; height: 30px" src="./img/audio-waves-white.png" alt="Icon Description">
                </i>
            </div>
            <div class="sidebar-brand-text mx-3">VoiceMaster</div>
        </a>
        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="course-selection.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Selection Page</span></a>
        </li>


        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="ai-course.jsp">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Course Page</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="login-log.jsp">
                <i class="fas fa-fw fa-table"></i>
                <span>Login Log</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="personal-info.jsp">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                <span>Profile</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <form class="form-inline">
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                </form>


                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">


                <!-- Page Heading -->
                <div class="row">
                    <div class="col-12">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h3 class="m-0 font-weight-bold text-primary"><%= course.getTitle() %>
                                </h3>
                            </div>
                            <div class="card-body">
                                <%=course.getContent()%>
                            </div>
                        </div>
                    </div>

                    <div id="template" class="col-12" style="display: none">
                        <div class="row">
                            <div class="col-lg-6 mb-4">
                                <!-- Project Card Example -->
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Scoring</h6>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="small font-weight-bold">Intonation<span class="float-right">{{intonation}}</span>
                                        </h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar {{intonationStyle}}" role="progressbar"
                                                 style="width: {{intonation}}%"
                                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <h4 class="small font-weight-bold">Loudness <span class="float-right">{{loudness}}</span>
                                        </h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar {{loudnessStyle}}" role="progressbar"
                                                 style="width: {{loudness}}%"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <h4 class="small font-weight-bold">Phrasing <span
                                                class="float-right">{{phrasing}}</span></h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar {{phrasingStyle}}" role="progressbar"
                                                 style="width: {{phrasing}}%"
                                                 aria-valuenow="60"
                                                 aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <h4 class="small font-weight-bold">Pronunciation <span
                                                class="float-right">{{pronunciation}}</span>
                                        </h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar {{pronunciationStyle}}" role="progressbar"
                                                 style="width: {{pronunciation}}%"
                                                 aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <h4 class="small font-weight-bold">Rhythm <span
                                                class="float-right">{{rhythm}}</span>
                                        </h4>
                                        <div class="progress  mb-4">
                                            <div class="progress-bar {{rhythmStyle}}" role="progressbar"
                                                 style="width: {{rhythm}}%"
                                                 aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>

                                        <h4 class="small font-weight-bold">Speed <span
                                                class="float-right">{{speed}}</span>
                                        </h4>
                                        <div class="progress mb-4">
                                            <div class="progress-bar {{speedStyle}}" role="progressbar"
                                                 style="width: {{speed}}%"
                                                 aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 mb-4">
                                <!-- Color System -->

                                <div class="mb-4">
                                    <div class="card {{intonationStyle}} text-white shadow">
                                        <div class="card-body">
                                            Intonation
                                            <div class="text-white-50 small">{{intonationCommand}}</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-4">
                                    <div class="card {{loudnessStyle}} text-white shadow">
                                        <div class="card-body">
                                            Loudness
                                            <div class="text-white-50 small">{{loudnessCommand}}</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-4">
                                    <div class="card {{phrasingStyle}} text-white shadow">
                                        <div class="card-body">
                                            Phrasing
                                            <div class="text-white-50 small">{{phrasingCommand}}</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-4">
                                    <div class="card {{pronunciationStyle}} text-white shadow">
                                        <div class="card-body">
                                            Pronunciation
                                            <div class="text-white-50 small">{{pronunciationCommand}}</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-4">
                                    <div class="card {{rhythmStyle}} text-white shadow">
                                        <div class="card-body">
                                            Rhythm
                                            <div class="text-white-50 small">{{rhythmCommand}}</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-4">
                                    <div class="card {{speedStyle}} text-white shadow">
                                        <div class="card-body">
                                            Speed
                                            <div class="text-white-50 small">{{speedCommand}}</div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h4 class="m-0 font-weight-bold text-primary">History Grade</h4>
                            </div>
                            <div class="card-body">
                                <div class="chart-area">
                                    <div class="chartjs-size-monitor">
                                        <div class="chartjs-size-monitor-expand">
                                            <div class=""></div>
                                        </div>
                                        <div class="chartjs-size-monitor-shrink">
                                            <div class=""></div>
                                        </div>
                                    </div>
                                    <canvas id="myAreaChart" width="578" height="320"
                                            style="display: block; width: 578px; height: 320px;"
                                            class="chartjs-render-monitor"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-6">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h4 class="m-0 font-weight-bold text-primary">Create Feature</h4>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <div class="p-2">
                                                <label class="text-lg text-primary">AUDIOUS</label>
                                                <div class="form-group">
                                                    <input type="file" class="form-control-file form-control-user"
                                                           placeholder="Some audious text" id="fileInput">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-6">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h4 class="m-0 font-weight-bold text-primary">Judge</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th>Audio ID</th>
                                            <th>Text</th>
                                            <th>Operation</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            for (int i = 0; i < audio.length(); i++) {
                                        %>
                                        <tr>
                                            <th><%= audio.getJSONObject(i).getInt("id") %>
                                            </th>
                                            <th><%= audio.getJSONObject(i).getString("text") %>
                                            </th>
                                            <th>
                                                <%
                                                    if (audio.getJSONObject(i).has("featureToken")) {
                                                %>
                                                <a href="#" class="btn btn-info btn-circle btn-sm"
                                                   onclick="createAudio(<%= audio.getJSONObject(i).getInt("id") %>, <%= course.getId() %>)">
                                                    <i class="fas fa-check"></i>
                                                </a>
                                                <%
                                                    }
                                                %>

                                            </th>
                                        </tr>
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-primary shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Create Time
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                            <%= course.getCreateTime() %>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Difficulty
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                            <%= course.getDifficulty
                                                    (
                                                    ) %>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-chalkboard-teacher fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-warning shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Midterm Date
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                            <%= course
                                                    .
                                                    getMidtermTime
                                                            (
                                                            ) %>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-dark shadow h-100 py-2">
                            <div class="card-body">
                                <div class="row no-gutters align-items-center">
                                    <div class="col mr-2">
                                        <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            Final Date
                                        </div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                            <%= course
                                                    .
                                                    getFinalTime
                                                            (
                                                            ) %>
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="index.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script>
    function changeStyle(score, key, template) {
        if (score < 60) {
            template = template.replaceAll(key, 'bg-danger');
        } else if (score < 70) {
            template = template.replaceAll(key, 'bg-warning');
        } else if (score < 80) {
            template = template.replaceAll(key, 'bg-primary');
        } else if (score < 90) {
            template = template.replaceAll(key, 'bg-info');
        } else if (score < 101) {
            template = template.replaceAll(key, 'bg-success');
        }
        return template;
    }

    function createAudio(audioId, classId) {
        var fileInput = $('#fileInput')[0];
        var file = fileInput.files[0];

        if (file) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var jsonData = {
                    "audio": e.target.result,
                    "classId": classId,
                    "audioId": audioId,
                };

                $.ajax({
                    type: 'POST',
                    url: '/front_war_exploded/audio',
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(jsonData),
                    success: function (response) {
                        response = JSON.parse(response);
                        let template = $("#template").html();
                        template = template.replaceAll('{{intonation}}', response.response.intonation)
                            .replaceAll('{{loudness}}', response.response.loudness)
                            .replaceAll('{{phrasing}}', response.response.phrasing)
                            .replaceAll('{{pronunciation}}', response.response.pronunciation)
                            .replaceAll('{{rhythm}}', response.response.rhythm)
                            .replaceAll('{{speed}}', response.response.speed)
                            .replaceAll('{{intonationCommand}}', response.response.intonationCommand)
                            .replaceAll('{{loudnessCommand}}', response.response.loudnessCommand)
                            .replaceAll('{{phrasingCommand}}', response.response.phrasingCommand)
                            .replaceAll('{{pronunciationCommand}}', response.response.pronunciationCommand)
                            .replaceAll('{{rhythmCommand}}', response.response.rhythmCommand)
                            .replaceAll('{{speedCommand}}', response.response.speedCommand);

                        template = changeStyle(response.response.intonation, '{{intonationStyle}}', template);
                        template = changeStyle(response.response.loudness, '{{loudnessStyle}}', template);
                        template = changeStyle(response.response.phrasing, '{{phrasingStyle}}', template);
                        template = changeStyle(response.response.pronunciation, '{{pronunciationStyle}}', template);
                        template = changeStyle(response.response.rhythm, '{{rhythmStyle}}', template);
                        template = changeStyle(response.response.speed, '{{speedStyle}}', template);

                        $("#template").html(template);
                        $("#template").removeAttr('style');

                        },
                    error: function (xhr, status, error) {
                        console.error('File upload failed. Status: ' + xhr.status);
                    }
                });
            };
            reader.readAsDataURL(file);
        } else {
            console.error('No file selected');
        }
    }
</script>
<script>
    // Set new default font family and font color to mimic Bootstrap's default styling
    Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#858796';

    function number_format(number, decimals, dec_point, thousands_sep) {
        // *     example: number_format(1234.56, 2, ',', ' ');
        // *     return: '1 234,56'
        number = (number + '').replace(',', '').replace(' ', '');
        var n = !isFinite(+number) ? 0 : +number, prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
            sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
            dec = (typeof dec_point === 'undefined') ? '.' : dec_point, s = '', toFixedFix = function (n, prec) {
                var k = Math.pow(10, prec);
                return '' + Math.round(n * k) / k;
            };
        // Fix for IE parseFloat(0.55).toFixed(0) = 0;
        s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
        if (s[0].length > 3) {
            s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
        }
        if ((s[1] || '').length < prec) {
            s[1] = s[1] || '';
            s[1] += new Array(prec - s[1].length + 1).join('0');
        }
        return s.join(dec);
    }

    // Area Chart Example
    var ctx = document.getElementById("myAreaChart");
    var myLineChart = new Chart(ctx, {
        type: 'line', data: {
            labels: [
                <%
                for (int i=0;i<score.length();i++){
                %>
                "<%= score.getJSONObject(i).getString("createTime") %>",
                <%
                }
                %>
            ],
            datasets: [{
                label: "Score",
                lineTension: 0.3,
                backgroundColor: "rgba(78, 115, 223, 0.05)",
                borderColor: "rgba(78, 115, 223, 1)",
                pointRadius: 3,
                pointBackgroundColor: "rgba(78, 115, 223, 1)",
                pointBorderColor: "rgba(78, 115, 223, 1)",
                pointHoverRadius: 3,
                pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
                pointHoverBorderColor: "rgba(78, 115, 223, 1)",
                pointHitRadius: 10,
                pointBorderWidth: 2,
                data: [
                <%
                for (int i=0;i<score.length();i++){
                %>
                <%= score.getJSONObject(i).getInt("finalScore") %>,
                <%
                }
                %>
                ],
            }],
        }, options: {
            maintainAspectRatio: false, layout: {
                padding: {
                    left: 10, right: 25, top: 25, bottom: 0
                }
            }, scales: {
                xAxes: [{
                    time: {
                        unit: 'date'
                    }, gridLines: {
                        display: false, drawBorder: false
                    }, ticks: {
                        maxTicksLimit: 7
                    }
                }], yAxes: [{
                    ticks: {
                        maxTicksLimit: 10, padding: 10, // Include a dollar sign in the ticks
                        callback: function (value, index, values) {
                            return number_format(value);
                        }
                    }, gridLines: {
                        color: "rgb(234, 236, 244)",
                        zeroLineColor: "rgb(234, 236, 244)",
                        drawBorder: false,
                        borderDash: [2],
                        zeroLineBorderDash: [2]
                    }
                }],
            }, legend: {
                display: false
            }, tooltips: {
                backgroundColor: "rgb(255,255,255)",
                bodyFontColor: "#858796",
                titleMarginBottom: 10,
                titleFontColor: '#6e707e',
                titleFontSize: 14,
                borderColor: '#dddfeb',
                borderWidth: 1,
                xPadding: 15,
                yPadding: 15,
                displayColors: false,
                intersect: false,
                mode: 'index',
                caretPadding: 10,
                callbacks: {
                    label: function (tooltipItem, chart) {
                        var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                        return datasetLabel + ': ' + number_format(tooltipItem.yLabel);
                    }
                }
            }
        }
    });
</script>
</body>

</html>