$(function(){
	/*1.数据展示*/
    var currPage = 1;
    var render = function(){
        getUserData({
            page:currPage,
            pageSize:5
        },function(data){
            /*渲染列表*/
            $('tbody').html(template('list',data));
            /*渲染分页*/
            setPaginator(data.page,Math.ceil(data.total/data.size),render);
        });
    };
    render();
    /*2.分页展示*/
    var setPaginator = function(pageCurr,pageSum,callback){
        /*获取需要初始的元素 使用bootstrapPaginator方法*/
        $('.pagination').bootstrapPaginator({
            /*当前使用的是3版本的bootstrap*/
            bootstrapMajorVersion:3,
            /*配置的字体大小是小号*/
            size:'small',
            /*当前页*/
            currentPage:pageCurr,
            /*一共多少页*/
            totalPages:pageSum,
            /*点击页面事件*/
            onPageClicked:function(event, originalEvent, type, page){
                /*改变当前页再渲染 page当前点击的按钮的页面*/
                currPage = page;
                callback && callback();
            }
        });
    }
    $('#addDrug').on('click', function () {
        $('#addModal').modal('show');
    });
})
/*获取用户数据调用的接口*/
var getUserData = function(params,callback){
//  $.ajax({
//      type:'get',
//      url:'/user/queryUser',
//      data:params,
//      datType:'json',
//      success:function(data){
//          callback && callback(data);
//      }
//  });
};
/*删除功能*/
$('.deleteDrug').on('click',function(){
    /*1.准备模态框*/
    var deleteModal =
                    '<div class="modal fade" id="deleteModal">'+
                        '<div class="modal-dialog modal-sm">'+
                            '<div class="modal-content">'+
                                '<div class="modal-header">'+
                                    '<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>'+
                                    '<h4 class="modal-title">温馨提示</h4>'+
                                '</div>'+
                                '<div class="modal-body">'+
                                    '<p class="text-danger"><span class="glyphicon glyphicon-info-sign"></span> 您确定要删除吗？</p>'+
                                '</div>'+
                                '<div class="modal-footer">'+
                                    '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'+
                                    '<button type="button" class="btn btn-primary">确定</button>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                    '</div>';
    /*2.把模态框追加到页面当中*/
    $('body').append(deleteModal);
    /*3.显示模态框*/
    $('#deleteModal').modal('show');
    /*4.当点击确定按钮的时候进行对出*/
    /*5.防止多次绑定  在绑定之前先注销上一次的绑定*/
    $('#deleteModal').off('click','.btn-primary').on('click','.btn-primary',function(){
        /*6.发送退出请求*/
       alert("删除成功！");
       $('#deleteModal').modal('hide');
       $(".deleteDrug").attr("disabled",true);
    	$(".deleteDrug").text("已删除");
    	$(".addShouquan").attr("disabled",true);
//      $.ajax({
//          type:'get',
//          url:'/employee/employeeLogout',
//          data:{},
//          dataType:'json',
//          success:function(data){
//              setTimeout(function(){
//                  if(data.success){
//                      /*7.退出成功*/
//                      location.href = 'login.html';
//                  }
//              },500);
//          }
//      });
    });
});