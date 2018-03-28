<div class="modal fade" id="purge-task-queue-modal" tabindex="-1" role="dialog"
     aria-labelledby="purge-task-queue-modal-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="purge-task-queue-modal-label">
                    此项操作将会清空线程池任务队列
                </h4>
            </div>
            <div class="modal-body">
                <input hidden id="purge-task-queue-thread-pool-bean-name-text"/>
                <p id="purge-task-queue-thread-pool-message">

                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="confirmPurgeTaskQueue('${base}/monitor/thread/purge')">确定</button>
            </div>
        </div>
    </div>
</div>