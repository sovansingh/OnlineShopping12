$(function() {
	
	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	/*case 'Product Management':
		$('#manageProduct').addClass('active');
		break;
*/
		case 'Shopping Cart':
		$('#userModel').addClass('active');
		break;		
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

/*	var products= [
		
					['1','ABC'],
					['2','DEF'],
					['3','GHI'],
					['4','JKL'],
					['5','MNO'],
					['6','PQR'],
					['7','STU'],
					['8','VWX'],
					['9','YZA']
	];
*/	
	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else {
			jsonUrl = window.contexRoot + '/json/data/category/'+wondow.categoryId+'/products';
		}
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3records','5 Records','10 Records','All']],
			pagelength:5,
			/*data: products*/
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
						{
							data : 'code',
							mRender : function(data, type, row) {
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
							}
						},
						{
							data : 'name'
						},
						{
							data : 'brand'
						},
						{
							data : 'unitPrice',
							mRender: function(data, type, row) {
								return '&#8377; ' + data
							}
						},
						{
							data : 'quantity',
							mRender: function(data, type, row) {
								if(data < 1){
									return '<span style="color:red;">out Of Stock!</span>';
								}
								return data;
							}
						},
						{
							data : 'id',
							mRender: function(data, type, row) {
								var str  = '';
								bSortable: false,
								str +='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary "><span class="glyphicon glyphicon-eye-open "></span></a> &#160;';
								
								if(row.quantity < 1){
									str+='<a href="javascript.vid(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart "></span></a>';
								}else {
									str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart "></span></a>';	
								}
								
								
								return str;
							}
						}
						
			]
		});
	}

});