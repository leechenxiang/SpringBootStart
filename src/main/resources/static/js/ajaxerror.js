$.ajax({
    	url: "/err/getAjaxerror",
    	type: "POST",
    	async: false,
    	success: function(data) {
    		debugger;
            if(data.status == 200 && data.msg == "OK") {
            	alert("success");
            } else {
            	alert("error");
            }
    	},
        error: function (response, ajaxOptions, thrownError) {
        	debugger;
        	alert("error");       
        }
    });