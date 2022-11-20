$("#sc").change(function(){
    var sc = $(this).val();
    console.log(sc);
    
    $.ajax({
        type: 'GET',
        url: "./dropdownlist/" + sc,
        success: function(data){
            var slctSubcat=$('#theme'), option="";
            slctSubcat.empty();
            
            for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i][0]+ "'>"+data[i][1] + "</option>";
            }
            slctSubcat.append(option);
        },
        error:function(){
            alert("error");
        }

    });
});