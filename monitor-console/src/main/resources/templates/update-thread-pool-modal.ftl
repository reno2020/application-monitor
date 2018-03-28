<div class="modal fade" id="update-thread-pool-modal" tabindex="-1" role="dialog"
     aria-labelledby="update-thread-pool-modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="update-thread-pool-modal-label">
                    此项操作将会更新线程池属性
                </h4>
            </div>
            <div class="modal-body">
                <input hidden id="update-thread-pool-bean-name-text"/>
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="core-pool-size-text" class="col-sm-3 control-label">核心池容量</label>
                        <div class="col-sm-7">
                            <input type="number" id="core-pool-size-text" name="core-pool-size-text" class="form-control well"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="maximum-pool-size-text" class="col-sm-3 control-label">最大池容量</label>
                        <div class="col-sm-7">
                            <input type="number" id="maximum-pool-size-text" name="maximum-pool-size-text" class="form-control well"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="keep-alive-second-text" class="col-sm-3 control-label">存活间隔(秒)</label>
                        <div class="col-sm-7">
                            <input type="number" id="keep-alive-second-text" name="keep-alive-second-text" class="form-control well"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="allow-core-thread-timeout-text" class="col-sm-4 control-label">是否允许核心线程超时</label>
                        <div class="col-sm-6">
                            <div class="col-sm-3">
                                <label class="radio"><input type="radio" id="allow-core-thread-timeout-true" name="allow-core-thread-timeout-text" value="true">是</label>
                            </div>
                            <div class="col-sm-3">
                                <label class="radio"><input type="radio" id="allow-core-thread-timeout-false" name="allow-core-thread-timeout-text" value="false">否</label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="confirmUpdateThreadPool('${base}/monitor/thread/update')">确定
                </button>
            </div>
        </div>
    </div>
</div>