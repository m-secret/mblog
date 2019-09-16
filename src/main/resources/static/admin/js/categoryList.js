layui.use(['form', 'layer', 'table'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    
    var tableIns = table.render({
        elem: '#categoryList',
        url:  '/admin/getCategory',
        cellMinWidth: 95,
        page: true,
        height: 'full-125',
        limit: 10,
        limits: [10, 15, 20, 25],
        id: "blogListTable",
        cols: [[
           /* {type: "checkbox", fixed: "left",width:'3%'},*/
            {type: 'numbers',width :'6%',title: '序号'},
            {field: 'cid', title: 'ID',  align: "center",width:'10%'},
            {field: 'cName', title: '分类名', align:"center",width:'30%'},
            {field: 'total', title: '文章数', align: 'center',width:'20%'},
            {title: '操作',  templet: '#categoryListBar', fixed: "right", align: "center",width:'35%'}
        ]]
    });



    //列表操作
    table.on('tool(categoryList)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if (layEvent === 'edit') { //编辑
            layer.prompt({
                title: '请输入新的分类名'
            },function(val, index){
                layer.confirm('确定修改此分类？', {icon: 3, title: '提示信息'}, function (i) {
                    $.get("/admin/changeCategoryName",{
                        cid : data.cid,  //将需要删除的newsId作为参数传入
                        cName: val
                    },function(data){
                        if(data === "success"){
                            tableIns.reload();
                            layer.close(i)
                            layer.close(index);
                            layer.msg("修改成功")
                        }
                    })
                });
            });
        } else if (layEvent === 'del') { //删除
            layer.confirm('确定删除此分类？', {icon: 3, title: '提示信息'}, function (index) {
                $.get("/admin/deleteCategory",{
                     cid : data.cid  //将需要删除的newsId作为参数传入
                },function(data){
                    if(data === "success"){
                        tableIns.reload();
                        layer.close(index);
                        layer.msg("删除成功");
                    }
                 })
            });
        }
    });

    $(".addCategoryBtn").click(function(){
        layer.prompt({
            title: '请输入分类名'
        },function(val, index){
            layer.confirm('确定添加此分类？', {icon: 3, title: '提示信息'}, function (i) {
                $.get("/admin/addCategory",{
                    cName: val
                },function(data){
                    if(data === "success"){
                        tableIns.reload();
                        layer.close(i)
                        layer.close(index);
                        layer.msg("添加成功")
                    }
                })
            });
        });
    })



});


