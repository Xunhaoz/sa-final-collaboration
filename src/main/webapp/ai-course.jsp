<%@ page import="com.example.front.app.Course" %>
<%@ page import="org.json.JSONArray" %>
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
            <a class="nav-link" href="ai-course.html">
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
                <%
                    Course course = (Course) request.getAttribute("course");
                %>
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-12">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h3 class="m-0 font-weight-bold text-primary">
                                    <%= course.getTitle() %>
                                </h3>
                            </div>
                            <div class="card-body">
                                <%= course.getContent() %>
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
                                                <label class="text-lg text-primary">TEXT</label>
                                                <div class="form-group">
                                                    <input type="text" class="form-control form-control-user"
                                                           placeholder="Some text" id="text">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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

                                <div class="form-group row">
                                    <div class="col-lg-3 col-sm-3 mb-1 mb-sm-0">
                                        <div class="p-3">
                                            <a href="#" class="btn btn-success btn-icon-split"
                                               onclick="uploadFile(<%= course.getId() %>)" id="CorU">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-check"></i>
                                                    </span>
                                                <span class="text" id="CorUText">Confirm</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-6">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h4 class="m-0 font-weight-bold text-primary">History</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable">
                                        <thead>
                                        <tr>
                                            <th>Audio ID</th>
                                            <th>Text</th>
                                            <th>Operation</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            JSONArray audio = (JSONArray) request.getAttribute("audio");
                                            for (int i = 0; i < audio.length(); i++) {
                                        %>
                                        <tr>
                                            <th><%= audio.getJSONObject(i).getInt("id") %>
                                            </th>
                                            <th><%= audio.getJSONObject(i).getString("text") %>
                                            </th>
                                            <th>
                                                <% if (!audio.getJSONObject(i).has("featureToken")) { %>

                                                <a href="#" class="btn btn-success btn-circle btn-sm"
                                                   onclick="selectAudio(<%= audio.getJSONObject(i).getInt("id") %>)">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                                <%}%>
                                                <a href="#" class="btn btn-danger btn-circle btn-sm"
                                                   onclick="deleteAudio(<%= audio.getJSONObject(i).getInt("id") %>)">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                                <% if (!audio.getJSONObject(i).has("featureToken")) { %>
                                                <a href="#" class="btn btn-info btn-circle btn-sm"
                                                   onclick="judgeAudio(<%= audio.getJSONObject(i).getInt("id") %>)">
                                                    <i class="fas fa-check"></i>
                                                </a>
                                                <%}%>

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
                                            <%= course.getDifficulty() %>
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
                                            <%= course.getMidtermTime() %>
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
                                            <%= course.getFinalTime() %>
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
<script>

    function uploadFile(classId) {
        var fileInput = $('#fileInput')[0];
        var file = fileInput.files[0];

        if (file) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var base64Data = e.target.result;
                sendDataToServer(base64Data, classId);
            };
            reader.readAsDataURL(file);
        } else {
            console.error('No file selected');
        }
    }

    function sendDataToServer(base64Data, classId) {
        var jsonData = {
            "audio": base64Data,
            "classId": classId,
            "text": $("#text").val()
        };

        $.ajax({
            type: 'POST',
            url: '/front_war_exploded/audio',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(jsonData),
            success: function () {
                location.reload();
                console.log('File uploaded successfully');
            },
            error: function (xhr, status, error) {
                console.error('File upload failed. Status: ' + xhr.status);
            }
        });
    }

    function deleteAudio(id) {
        $.ajax({
            type: 'DELETE',
            url: '/front_war_exploded/audio',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({"id": id}),
            success: function () {
                location.reload();
                console.log('File uploaded successfully');
            },
            error: function (xhr, status, error) {
                console.error('File upload failed. Status: ' + xhr.status);
            }
        });
    }

    function selectAudio(id) {
        $.ajax({
            type: 'GET',
            url: '/front_war_exploded/audio',
            contentType: 'application/json;charset=UTF-8',
            headers: {"id": id},
            cache: false,
            dataType: 'json',
            timeout: 5000,
            success: function (response) {
                $("#text").val(response.response.text);
                $("#CorUText").text("Update");
                $("#CorU").attr("onclick", "updateAudio(" + response.response.id + ")");
            },
            error: function (xhr, status, error) {
                console.error('File upload failed. Status: ' + xhr.status);
            }
        });
    }

    function updateAudio(AudioId) {
        var fileInput = $('#fileInput')[0];
        var file = fileInput.files[0];

        if (file) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var base64Data = e.target.result;
                updateDataToServer(base64Data, AudioId);
            };
            reader.readAsDataURL(file);
        } else {
            console.error('No file selected');
        }
    }

    function updateDataToServer(base64Data, AudioId) {
        var jsonData = {
            "id": AudioId,
            "audio": base64Data,
            "text": $("#text").val()
        };

        $.ajax({
            type: 'PUT',
            url: '/front_war_exploded/audio',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(jsonData),
            success: function () {
                location.reload();
                console.log('File uploaded successfully');
            },
            error: function (xhr, status, error) {
                console.error('File upload failed. Status: ' + xhr.status);
            }
        });
    }

    function judgeAudio(id) {
        $.ajax({
            type: 'POST',
            url: '/front_war_exploded/judge',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({"id": id}),
            success: function () {
                location.reload();
                console.log('File uploaded successfully');
            },
            error: function (xhr, status, error) {
                console.error('File upload failed. Status: ' + xhr.status);
            }
        });
    }

</script>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</body>

</html>