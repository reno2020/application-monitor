<#assign base = request.contextPath>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Console</title>
    <!-- Bootstrap -->
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/css/font-awesome.css" rel="stylesheet">
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${base}/js/scrolltopcontrol.js"></script>
    <!--jquery.hammer手势插件-->
    <script type="text/javascript" src="${base}/js/hammer.min.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.hammer.js"></script>
    <!--默认样式-->
    <link href="${base}/css/default.css" rel="stylesheet">
    <!--页面加载进度条-->
    <link href="${base}/css/dataurl.css" rel="stylesheet">
    <script type="text/javascript" src="${base}/js/pace.min.js"></script>
    <!--artTemplate-->
    <script type="text/javascript" src="${base}/js/template.js"></script>
    <!--自定义js-->
    <script type="text/javascript" src="${base}/js/default.js"></script>
    <!--toastr-消息框插件-->
    <link href="https://cdn.bootcss.com/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/toastr.js/latest/js/toastr.min.js"></script>

    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${base}/console">Throwable Monitor</a>
            </div>
        </div>
    </nav>

    <div class="container-fluid all">
        <div class="sidebar">
            <ul class="nav">
                <li class="active"><a href="#"
                                      onclick="loadDashboard('${base}/tpl/dashboard-content.tpl')">Dashboard</a></li>
                <li><a href="#" onclick="loadSystemInfo('${base}/tpl/system-content.tpl','${base}/monitor/os')">系统监控</a>
                </li>
                <li class="has-sub">
                    <a href="javascript:void(0);"><span>线程监控</span><i
                            class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
                        <li><a href="#"
                               onclick="loadThreadPoolInfo('${base}/tpl/thread-pool-content.tpl','${base}/monitor/thread/metadata/list','${base}')"><i
                                class="fa fa-circle-o fa-fw"></i>&nbsp;线程池监控</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="main-content row" id="main-content">
            <div class="col-sm-12">
                <h3 class="data-title">系统信息</h3>
                <div>
                    <h3 class="data-sub-title">基本信息</h3>
                    <div class="table-responsive">
                        <table class="table table-bordered" style="width: 60%">
                            <tbody>
                            <tr class="info">
                                <td>逻辑核心数目</td>
                                <td>4</td>
                            </tr>
                            <tr class="info">
                                <td>逻辑核心数目</td>
                                <td>411111</td>
                            </tr>
                            <tr class="info">
                                <td>逻辑核心数目</td>
                                <td>422222222222</td>
                            </tr>
                            <tr class="info">
                                <td>逻辑核心数目</td>
                                <td>41</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div>
                    <h3 class="data-sub-title">内存信息</h3>
                    <div class="table-responsive">
                        <table class="table table-bordered" style="width: 60%">
                            <tbody>
                            <tr class="info">
                                <td>总内存空间</td>
                                <td>100000000 KB</td>
                                <td>10000 MB</td>
                            </tr>
                            <tr class="info">
                                <td>已使用内存空间</td>
                                <td>100000000 KB</td>
                                <td>10000 MB</td>
                            </tr>
                            <tr class="info">
                                <td>剩余内存空间</td>
                                <td>100000000 KB</td>
                                <td>10000 MB</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div>
                    <h3 class="data-sub-title">磁盘信息</h3>
                </div>
                <div>
                    <h3 class="data-sub-title">虚拟机信息</h3>
                </div>
            </div>
        </div>
        <hr>
        <footer class="footer navbar-fixed-bottom">
            <p style="text-align: center">
                <a href="https://github.com/zjcscut" target="_blank">
                    <i class="fa fa-2x fa-github"></i>
                </a>
            </p>
            <p style="text-align: center" id="copy-right"></p>
        </footer>
    </div>
</div>
<a href="#top" id="goTop"><i class="fa fa-angle-up fa-3x"></i></a>
<#--<a href="https://github.com/zjcscut">-->
<#--<img class="forkme" src="${base}/img/forkme.png" alt="Fork me on GitHub">-->
<#--</a>-->
<!-- 外部引入的模态框 -->
<#include "purge-task-queue-modal.ftl">
<#include "update-thread-pool-modal.ftl">
</body>
</html>