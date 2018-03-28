$(function () {
    pageInitModule.setWidth();
    pageInitModule.setSidebar();
    pageInitModule.setCarousel();
});
$(window).resize(function () {
    pageInitModule.setWidth();
});
$(window).scroll(function () {
    pageInitModule.setScrollToTop();
});

/*
* init page when page load
*/
var pageInitModule = (function (mod) {
    mod.setCarousel = function () {
        try {
            $('.carousel').hammer().on('swipeleft', function () {
                $(this).carousel('next');
            });
            $('.carousel').hammer().on('swiperight', function () {
                $(this).carousel('prev');
            });
        } catch (e) {
            console.log("you mush import hammer.js and jquery.hammer.js to let the carousel can be touched on mobile");
        }
    };
    mod.setWidth = function () {
        if ($(window).width() < 768) {
            $(".sidebar").css({left: -220});
            $(".all").css({marginLeft: 0});
        } else {
            $(".sidebar").css({left: 0});
            $(".all").css({marginLeft: 220});
        }
    };
    mod.setScrollToTop = function () {
        var top = $(window).scrollTop();
        if (top < 60) {
            $('#goTop').hide();
        } else {
            $('#goTop').show();
        }
    };
    mod.setSidebar = function () {
        $('[data-target="sidebar"]').click(function () {
            var asideLeft = $(".sidebar").offset().left;
            if (asideLeft === 0) {
                $(".sidebar").animate({left: -220});
                $(".all").animate({marginLeft: 0});
            }
            else {
                $(".sidebar").animate({left: 0});
                $(".all").animate({marginLeft: 220});
            }
        });
        $(".has-sub>a").click(function () {
            $(this).parent().siblings().find(".sub-menu").slideUp();
            $(this).parent().find(".sub-menu").slideToggle();
        });
        var currentUrl = window.location.href.toLowerCase();
        $(".navbar-nav a[href],.sidebar a[href]").each(function () {
            var href = $(this).attr("href").toLowerCase();
            var isActive = false;
            $(".breadcrumb>li a[href]").each(function (index) {
                if (href === $(this).attr("href").toLowerCase()) {
                    isActive = true;
                    return false;
                }
            });
            if (currentUrl.indexOf(href) > -1 || isActive) {
                $(this).parent().addClass("active");
                if ($(this).parents("ul").attr("class") === "sub-menu") {
                    $(this).parents("ul").slideDown();
                    $(this).parents(".has-sub").addClass("active");
                }
            }
        });
    };
    return mod;
})(window.pageInitModule || {});

function getCurrentYear() {
    return new Date().getFullYear();
}

$(function () {
    var copyRight = '&copy; 2016-' + getCurrentYear() + ' Throwable. All Rights Reserved.Contact me:739805340@qq.com';
    $('#copy-right').html(copyRight);
});


function fixActiveStatus() {
    $(this).parent().addClass("active");
    if ($(this).parents("ul").attr("class") === "sub-menu") {
        $(this).parents("ul").slideDown();
        $(this).parents(".has-sub").addClass("active");
    }
}

function loadDashboard(tpl) {
    $(function () {
        $.get(tpl, function (result) {
            var render = template.compile(result);
            var data = {};
            $('#main-content').html(render(data))
        });
    });
}

function loadSystemInfo(tpl, url) {
    $(function () {
        $.get(tpl, function (result) {
            var render = template.compile(result);
            $.ajax({
                url: url,
                method: "GET",
                dataType: 'json',
                success: function (data) {
                    $('#main-content').html(render(data))
                }
            });
        });
    });
}

function loadThreadPoolInfo(tpl, url, context) {
    $(function () {
        $.get(tpl, function (result) {
            var render = template.compile(result);
            $.ajax({
                url: url,
                method: "GET",
                dataType: 'json',
                success: function (data) {
                    $('#main-content').html(render(data))
                }
            });
        });
    });
}

function purgeTaskQueue(btn) {
    var tr = btn.parentNode.parentNode;
    var tds = tr.getElementsByTagName('td');
    var td = tds[0];
    var beanName = td.innerHTML;
    $('#purge-task-queue-thread-pool-bean-name-text').val(beanName);
    var message = '即将清空线程池[' + beanName + ']的任务队列。请在知悉风险的前提下按[确定]按钮执行操作！';
    $('#purge-task-queue-thread-pool-message').html(message);
    $('#purge-task-queue-modal').modal('show');
}

function confirmPurgeTaskQueue(url) {
    var beanName = $('#purge-task-queue-thread-pool-bean-name-text').val();
    $.ajax({
        url: url,
        method: "POST",
        data: {
            beanName: beanName
        },
        dataType: 'json',
        success: function (data) {
            $('#purge-task-queue-modal').modal('hide');
            var content;
            if (data && !data.result) {
                content = "清空线程池[" + beanName + "]任务队列失败!";
                toastr.error(content, '警告！');
            } else {
                content = "清空线程池[" + beanName + "]任务队列成功!";
                toastr.success(content, '操作成功！');
                loadThreadPoolInfo('/tpl/thread-pool-content.tpl', '/monitor/thread/metadata/list');
            }
        }
    });
}

function updateThreadPool(btn) {
    var tr = btn.parentNode.parentNode;
    var tds = tr.getElementsByTagName('td');
    var td = tds[0];
    var beanName = td.innerHTML;
    $('#update-thread-pool-bean-name-text').val(beanName);
    $('#core-pool-size-text').val(tds[1].innerHTML);
    $('#maximum-pool-size-text').val(tds[2].innerHTML);
    $('#keep-alive-second-text').val(tds[3].innerHTML);
    var allow = tds[4].innerHTML === 'true';
    if (allow) {
        var allowRadio = $('#allow-core-thread-timeout-true');
        allowRadio.parent('label').addClass('active');
        allowRadio.prop('checked', 'checked');
    } else {
        var notAllowRadio = $('#allow-core-thread-timeout-false');
        notAllowRadio.parent('label').addClass('active');
        notAllowRadio.prop('checked', 'checked');
    }
    $('#update-thread-pool-modal').modal('show');
}

function confirmUpdateThreadPool(url) {
    var beanName = $('#update-thread-pool-bean-name-text').val();
    var allowCoreThreadTimeout = $('input[name="allow-core-thread-timeout-text"]:checked').val();
    var corePoolSize = $('#core-pool-size-text').val();
    var maximumPoolSize = $('#maximum-pool-size-text').val();
    var keepAliveSecond = $('#keep-alive-second-text').val();
    if (allowCoreThreadTimeout === 'true' && keepAliveSecond <= 0) {
        $('#update-thread-pool-modal').modal('hide');
        toastr.error('允许核心线程超时，存活间隔(秒)必须大于0', '操作失败！');
        return;
    }
    $.ajax({
        url: url,
        method: "POST",
        data: {
            beanName: beanName,
            allowCoreThreadTimeOut: allowCoreThreadTimeout,
            corePoolSize: corePoolSize,
            maximumPoolSize: maximumPoolSize,
            keepAliveSecond: keepAliveSecond
        },
        dataType: 'json',
        success: function (data) {
            $('#update-thread-pool-modal').modal('hide');
            var content;
            if (data && !data.result) {
                content = "更新线程池[" + beanName + "]属性失败！";
                toastr.error(content, '警告！');
            } else {
                content = "更新线程池[" + beanName + "]属性成功！";
                toastr.success(content, '操作成功！');
                loadThreadPoolInfo('/tpl/thread-pool-content.tpl', '/monitor/thread/metadata/list');
            }
        }
    });
}
