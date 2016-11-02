var casper=require('casper').create({
	verbose:true,
	logLevel:"debug"
});

//var casper2=require('casper').create();

var URL_BASE="http://10.20.2.54:8080/";

var li=function(resource,C){
	
	
//	console.log(resource.url.indexOf('preview')!=-1);
	if(resource.url.indexOf('preview')!=-1)
	{
		this.echo("REQUESTS:"+resource.url);
	};
	
};

casper.on("resource.requested", li);
casper.on("resource.received",function(resource){
//	if(JSON.stringify(obj).contains('Internal Server Error'))
//		{
//		this.echo("goccha!");
//		}
	if(resource.url.indexOf('preview')!=-1)	
		{
			console.log(JSON.stringify(resource));
		}
	
});
//casper.options.onResourceReceived=function(obj){
//	this.echo("dataset:"+JSON.stringify(obj));
//};

casper.on('remote.message', function(message) {
    this.echo("REMOTE: "+message);
});

//var html=[];
//
//casper.start(URL_BASE+"user/datasets", function() {
//    html=this.evaluate(function() {
//    	var p=[];
//    	$(":checkbox").each(function(index,obj){
//    		var i={};
//    		i.name=$(obj).parent().find('small').text();
//    		i.id=$(obj).attr('id');
//    		p.push(i);
//    	});
//    	return p;
//    });
//    
//    
//    
//    
//    
//    console.log("result:"+JSON.stringify(html)+"\n");
//});
//
//
//casper.run();

var arr=[
//         {"id":"chk8","name":"School Basic Info"},
//         {"id":"chk3","name":"Total Enrolment"},
//         {"id":"chk4","name":"Monograde Enrolment \r\n"},
//         {"id":"chk5","name":"Multigrade Enrolment\r\n"},
//         {"id":"chk6","name":"Number of Balik-Aral\r\n"},
//         {"id":"chk7","name":"CCT/4Ps Recipients\r\n"},
//         {"id":"chk50","name":"Indigenous Peoples' Learners "},
//         {"id":"chk51","name":"Learners in Alternative Delivery Mode (ADM) "},
//         {"id":"chk52","name":"Learners in Arabic Language and Islamic Values Education (ALIVE) Classes"},
//         {"id":"chk53","name":"Muslim Learners"},
//         {"id":"chk54","name":"Number of Repeaters "},
//         {"id":"chk55","name":"Number of Learners Previously Enrolled in Other School"},
//         {"id":"chk56","name":"Number of Learners Previously Enrolled in Other Public School"},
//         {"id":"chk57","name":"Number of Learners Previously Enrolled in Private"},
//         {"id":"chk58","name":"End-of-School Year Enrollment "},
//         {"id":"chk59","name":"Number of Graduates"},
//         {"id":"chk60","name":"Number of Completers/Promotees"},
//         {"id":"chk61","name":"Number of Dropouts"},
//         {"id":"chk62","name":"Number of Transferees-In"},
//         {"id":"chk63","name":"Number of Transferees Out"},
//         {"id":"chk64","name":"Number of Late Enrollees"},
//         {"id":"chk65","name":"Number of Continuing Learners"},
//         {"id":"chk68","name":"Distance Education (DistEd) for SPED"},
//         {"id":"chk69","name":"Enhanced Instructional Management by Parents, Community and Teachers (e-IMPACT)"},
//         {"id":"chk70","name":"Modified In-School Off-School Approach (MISOSA)"},
//         {"id":"chk71","name":"Other School-Initiated Interventions"},
//         {"id":"chk72","name":"Open High School Program (OHSP)"},
//         {"id":"chk119","name":"SPED Graded"},
//         {"id":"chk120","name":"Madrasah Education"},
//         {"id":"chk121","name":"Children Living Far from School"},
//         {"id":"chk122","name":"Street Children"},
//         {"id":"chk125","name":"Total Enrolment in Kinder Summer Program"},
//         {"id":"chk126","name":"Enrolment By Age in Kinder Summer Program"},
//         {"id":"chk127","name":"Total Enrolment in ALS"},
         {"id":"chk128","name":"Enrolment By Age in ALS"},
//         {"id":"chk1002","name":"Total Enrolment By Age in Elementary Schools"},
//         {"id":"chk1003","name":"Enrolment By Age in Elementary"}, //LONG PROCESS
//         {"id":"chk1004","name":"Enrolment By Age in Kindergarten"},
//         {"id":"chk1005","name":"Enrolment By Age in Grade 1"},
//         {"id":"chk1006","name":"Enrolment By Age in Non-graded"},
//         {"id":"chk1007","name":"Total Enrolment By Age in Secondary Schools"},
//         {"id":"chk1008","name":"Enrolment By Age in Secondary"},
//         {"id":"chk1009","name":"Enrolment By Age in Secondary Non-graded"}, //error You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '-graded ON sp.school_year = age_ssnon-graded.sy_from AND sp.school_id = age_ssno' at line 1
//         {"id":"chk1501","name":"School Site Data"},
//         {"id":"chk2003","name":"Total Enrolment By Area of Exceptionality"},
//         {"id":"chk2004","name":"Learners with Learning Disability"},
//         {"id":"chk2005","name":"Learners with Hearing Impairment"},
//         {"id":"chk2006","name":"Learners with Visual Impairment - Blindness"},
//         {"id":"chk2007","name":"Learners with Visual Impairment - Low Vision"},
//         {"id":"chk2008","name":"Learners with Intellectual Disability/Mental Retardation"},
//         {"id":"chk2009","name":"Learners with Multiple Handicap"},
//         {"id":"chk2010","name":"Learners with Behavioral Problem"},
//         {"id":"chk2011","name":"Learners with Orthopedic Handicap"},
//         {"id":"chk2012","name":"Learners with Autism"},
//         {"id":"chk2013","name":"Learners with Communication Disorder"},
//         {"id":"chk2014","name":"Learners with Cerebral Palsy"},
//         {"id":"chk2015","name":"Learners with Special Health Problem"},
//         {"id":"chk2016","name":"Gifted/Fast Learners"},
//         {"id":"chk2018","name":"Total Gifted and Talented Learners Data"},
//         {"id":"chk2020","name":"Visual Impairment"}, 
//         {"id":"chk2021","name":"Hearing Impairment"}, 
//         {"id":"chk2022","name":"Learning Disability"},
//         {"id":"chk2023","name":"Intellectual Disability"},
//         {"id":"chk2024","name":"Autism Spectrum Disorder\r\n"},
//         {"id":"chk2025","name":"Emotional-Behavioral Disorder\r\n"}, 
//         {"id":"chk2026","name":"Orthopedic/Physical Handicap\r\n"}, 
//         {"id":"chk2027","name":"Speech/Language Disorder\r\n"},
//         {"id":"chk2028","name":"Cerebral Palsy\r\n"},
//         {"id":"chk2029","name":"Special Health Problem/Chronic Illness\r\n"},
//         {"id":"chk2030","name":"Multiple Disabilities\r\n"}, 
//         {"id":"chk2032","name":"Difficulty Seeing\r\n"},
//         {"id":"chk2033","name":"Difficulty Hearing\r\n"},
//         {"id":"chk2034","name":"Difficulty Walking, Climbing and Grasping"},
//         {"id":"chk2035","name":"Difficulty Remembering, Concentrating, Paying Attention and Understanding"},
//         {"id":"chk2036","name":"Difficulty Communicating"},
//         {"id":"chk2040","name":"Visual Impairment (Non-graded)"}, 
//         {"id":"chk2041","name":"Hearing Impairment (Non-graded)"}, 
//         {"id":"chk2042","name":"Learning Disability (Non-graded)"},
//         {"id":"chk2043","name":"Intellectual Disability (Non-graded)"},
//         {"id":"chk2044","name":"Autism Spectrum Disorder (Non-graded)"},
//         {"id":"chk2045","name":"Emotional-Behavioral Disorder (Non-graded)"},
//         {"id":"chk2046","name":"Orthopedic/Physical Handicap (Non-graded)"},
//         {"id":"chk2047","name":"Speech/Language Disorder (Non-graded)"},
//         {"id":"chk2048","name":"Cerebral Palsy (Non-graded)"}, 
//         {"id":"chk2049","name":"Special Health Problem/Chronic Illness  (Non-graded)"}, 
//         {"id":"chk2050","name":"Multiple Disabilities (Non-graded)"},
//         {"id":"chk2051","name":"Multiple Disability with Visual Impairment (Non-graded)\r\n"},
//         {"id":"chk2038","name":"Total Non-graded Learners with Exceptionalities"},
//         {"id":"chk2053","name":"Difficulty Seeing (Non-graded)"},
//         {"id":"chk2054","name":"Difficulty Hearing (Non-graded)"}, 
//         {"id":"chk2055","name":"Difficulty Walking, Climbing and Grasping (Non-graded)"},
//         {"id":"chk2056","name":"Difficulty Remembering, Concentrating, Paying Attention and Understanding (Non-graded)"},
//         {"id":"chk2057","name":"Difficulty Communicating (Non-graded)"},
//         {"id":"chk2059","name":"Total Leaners from SPED Classes or SPED Centers Mainstreamed in Regular Class"},
//         {"id":"chk2061","name":"Visual Impairment (Mainstreamed)"},
//         {"id":"chk2062","name":"Hearing Impairment (Mainstreamed)"}, 
//         {"id":"chk2063","name":"Learning Disability (Mainstreamed)"},
//         {"id":"chk2064","name":"Intellectual Disability (Mainstreamed)"},
//         {"id":"chk2065","name":"Autism Spectrum Disorder (Mainstreamed)"},
//         {"id":"chk2066","name":"Emotional-Behavioral Disorder (Mainstreamed)"},
//         {"id":"chk2067","name":"Orthopedic/Physical Handicap (Mainstreamed)"},
//         {"id":"chk2068","name":"Speech/Language Disorder (Mainstreamed)"},
//         {"id":"chk2069","name":"Cerebral Palsy (Mainstreamed)"},
//         {"id":"chk2070","name":"Special Health Problem/Chronic Illness  (Mainstreamed)"},
//         {"id":"chk2071","name":"Multiple Disabilities (Mainstreamed)"},
//         {"id":"chk2072","name":"Multiple Disability with Visual Impairment (Mainstreamed)\r\n"},
//         {"id":"chk2074","name":"Difficulty Seeing (Mainstreamed)"},
//         {"id":"chk2075","name":"Difficulty Hearing (Mainstreamed)"},
//         {"id":"chk2076","name":"Difficulty Walking, Climbing and Grasping (Mainstreamed)"},
//         {"id":"chk2077","name":"Difficulty Remembering, Concentrating, Paying Attention and Understanding (Mainstreamed)"},
//         {"id":"chk2078","name":"Difficulty Communicating (Mainstreamed)"},
//         {"id":"chk2080","name":"Total Learners with Exceptionalities Who Did Not Attend Any SPED Class"},
//         {"id":"chk2081","name":"Visual Impairment (Did Not Attend Any SPED Class)"},
//         {"id":"chk2082","name":"Hearing Impairment (Did Not Attend Any SPED Class)"},
//         {"id":"chk2083","name":"Learning Disability (Did Not Attend Any SPED Class)"},
//         {"id":"chk2084","name":"Intellectual Disability (Did Not Attend Any SPED Class)"},
//         {"id":"chk2085","name":"Autism Spectrum Disorder (Did Not Attend Any SPED Class)"}, 
//         {"id":"chk2086","name":"Emotional-Behavioral Disorder (Did Not Attend Any SPED Class)"}, 
//         {"id":"chk2087","name":"Orthopedic/Physical Handicap (Did Not Attend Any SPED Class)"},
//         {"id":"chk2088","name":"Speech/Language Disorder (Did Not Attend Any SPED Class)"}, 
//         {"id":"chk2089","name":"Cerebral Palsy (Did Not Attend Any SPED Class)"}, 
//         {"id":"chk2090","name":"Special Health Problem/Chronic Illness  (Did Not Attend Any SPED Class)"},
//         {"id":"chk2091","name":"Multiple Disabilities (Did Not Attend Any SPED Class)"},
//         {"id":"chk2092","name":"Multiple Disability with Visual Impairment (Did Not Attend Any SPED Class)"},
//         {"id":"chk3003","name":"Total Enrolment By Program in Elementary"},
//         {"id":"chk3004","name":"Enrolment in ALIVE"},
//         {"id":"chk3005","name":"Enrolment in SSES"},
//         {"id":"chk3007","name":"Total Enrolment By Program in Secondary Schools"},
//         {"id":"chk3008","name":"Enrolment in ALIVE in Secondary Schools"},
//         {"id":"chk3009","name":"Enrolment in Division Science High School"},
//         {"id":"chk3010","name":"Enrolment in ESEP"},
//         {"id":"chk3011","name":"Enrolment in Philippine High School for the Arts"},
//         {"id":"chk3012","name":"Enrolment in Regional Science High School"},
//         {"id":"chk3013","name":"Enrolment in Regular Curriculum"},
//         {"id":"chk3014","name":"Enrolment in Regular Curriculum in Schools Offering Regular and Special Programs"},
//         {"id":"chk3015","name":"Enrolment in Special Program in the Arts"},
//         {"id":"chk3016","name":"Enrolment in Special Program in Foreign Language"},
//         {"id":"chk3017","name":"Enrolment in Special Program in Journalism"},
//         {"id":"chk3018","name":"Enrolment in Special Program in Science, Technology and Engineering"},
//         {"id":"chk3019","name":"Enrolment in Special Program in Sports"},
//         {"id":"chk3020","name":"Enrolment in Special Program in Technical Vocational Education"},
//         {"id":"chk3021","name":"Enrolment in Special Program in Technical Vocational - Agriculture"},
//         {"id":"chk3022","name":"Enrolment in Special Program in Technical Vocational - Arts and Trade"},
//         {"id":"chk3023","name":"Enrolment in Special Program in Technical Vocational - Fishery"},
//         {"id":"chk3024","name":"Enrolment in Special Program in Technical Vocational - ICT"},
//         {"id":"chk3025","name":"Enrolment in SPED in Schools Offering Regular with Special Program"},
//         {"id":"chk3026","name":"Enrolment in SPED in Schools Offering Special Program"},
//         {"id":"chk3027","name":"Enrolment in Technical Vocational - Agriculture in Schools Offering Special Program"},
//         {"id":"chk3028","name":"Enrolment in Technical Vocational - Arts and Trade in Schools Offering Special Program"},
//         {"id":"chk3029","name":"Enrolment in Technical Vocational - Fishery in Schools Offering Special Program"},
//         {"id":"chk3502","name":"TLE Total Enrolment By Subject"},
//         {"id":"chk3503","name":"TLE Enrolment in Home Economics"},
//         {"id":"chk3504","name":"TLE Enrolment in Agri-Fishery Arts"},
//         {"id":"chk3505","name":"TLE Enrolment in Industrial Arts"},
//         {"id":"chk3506","name":"TLE Enrolment in Information and Communication Technology (ICT)"},
//         {"id":"chk4002","name":"Total Number of Dropout By Grade Level"},
         {"id":"chk4003","name":"Total Number of Dropouts By Cause"}, //ERROR
//         {"id":"chk4004","name":"Number of Dropouts Caused By Domestic/Family-Related Factors"},
//         {"id":"chk4005","name":"Number of Dropouts Caused By Individual-Related Factors"},
//         {"id":"chk4006","name":"Number of Dropouts Caused By School-Related Factors"},
//         {"id":"chk4007","name":"Number of Dropouts Caused By Geographical/Environmental Factors"},
//         {"id":"chk4008","name":"Number of Dropouts Caused By Financial-Related Factors and Others"},
//         {"id":"chk5001","name":"Teaching Personnel"},
//         {"id":"chk5002","name":"Non-Teaching Personnel"},
//         {"id":"chk5004","name":"Locally-funded Personnel"},
//         {"id":"chk5005","name":"Personnel By Grade Level"},
//         {"id":"chk5006","name":"Number of  Teachers by Teaching Assignment and by Area of Specialization"},
//         {"id":"chk5007","name":"Number of Teachers By Residence"},
//         {"id":"chk6002","name":"Total Instructional Rooms"},
//         {"id":"chk6004","name":"Total Standard Instructional Rooms"},
//         {"id":"chk6005","name":"Standard Complete Instructional Rooms"},
//         {"id":"chk6006","name":"Standard Incomplete Instructional Rooms"},
//         {"id":"chk6007","name":"Non-Standard / Makeshift Rooms"},
//         {"id":"chk6009","name":"Total Non-instructional Rooms"},
//         {"id":"chk6010","name":"Complete Non-instructional Rooms"},
//         {"id":"chk6011","name":"Incomplete Non-instructional Rooms"},
//         {"id":"chk6014","name":"Total Number of Existing Rooms By Fund Source"},
//         {"id":"chk6015","name":"Number of Existing Instructional Rooms By Fund Source"},
//         {"id":"chk6016","name":"Number of Existing Other Instructional Rooms By Fund Source"},
//         {"id":"chk6017","name":"Number of Existing Non-instructional Rooms By Fund Source"},
//         {"id":"chk6019","name":"Total Number of Rooms On-going Construction By Fund Source"},
//         {"id":"chk6020","name":"Number of Instructional Rooms On-going Construction By Fund Source"},
//         {"id":"chk6021","name":"Number of Non-instructional Rooms On-going Construction By Fund Source"},
//         {"id":"chk6022","name":"Rooms Needing Repair"},{"id":"chk6023","name":"Buildable Space"},
//         {"id":"chk6024","name":"Makeshift, Condemned and Condemnable"},
//         {"id":"chk6025","name":"Class Furniture"},
//         {"id":"chk6026","name":"Toilets and Urinals"},
//         {"id":"chk6501","name":"Water Supply"},
//         {"id":"chk6502","name":"Electrical Supply"},
//         {"id":"chk7002","name":"Total Number of Computers By Fund Source"},
//         {"id":"chk7004","name":"Total Number of Computers for Academic Use"},
//         {"id":"chk7005","name":"Number of Desktop/Notebook/Netbook/Tablet for Academic Use"},
//         {"id":"chk7006","name":"Number of Desktop Virtual Terminal for Academic Use"},
//         {"id":"chk7007","name":"Number of Desktop Computers Academic Use "},
//         {"id":"chk7008","name":"Number of Notebook Computers for Academic Use"},
//         {"id":"chk7009","name":"Number of Tablet Computers for Academic Use"},
//         {"id":"chk7011","name":"Total Number of Computers for Administrative Use"},
//         {"id":"chk7012","name":"Number of Desktop/Notebook/Netbook/Tablet for Administrative Use"},
//         {"id":"chk7013","name":"Number of Desktop Virtual Terminal for Administrative Use"},
//         {"id":"chk7014","name":"Number of Desktop Computers Administrative Use "},
//         {"id":"chk7015","name":"Number of Notebook Computers for Administrative Use"},
//         {"id":"chk7016","name":"Number of Tablet Computers for Administrative Use"},
//         {"id":"chk7018","name":"Total Number of Computers Needing Repair"},
//         {"id":"chk7019","name":"Number of Desktop/Notebook/Netbook/Tablet Computers Needing Repair"},
//         {"id":"chk7020","name":"Number of Desktop Virtual Terminal Needing Repair"},
//         {"id":"chk7023","name":"Wired"},
//         {"id":"chk7024","name":"Fixed Wireless"},
//         {"id":"chk7025","name":"Satellite"},
//         {"id":"chk7026","name":"USB Modem"},
//         {"id":"chk7028","name":"Wired Connection By Fund Source"},
//         {"id":"chk7029","name":"Fixed Wireless Connection By Fund Source"},
//         {"id":"chk7030","name":"Satellite Connection By Fund Source"},
//         {"id":"chk7031","name":"USB Modem Connection By Fund Source'"},
//         {"id":"chk7032","name":"Availability of Internet Connection and ISP"},
//         {"id":"chk7033","name":"Availability of Cellphone Network"},
//         {"id":"chk7034","name":"Internet Connection By ISP and Fund Source"},
//         {"id":"chk8001","name":"Agriculture and Fishery Resources"},
//         {"id":"chk8002","name":"Class Disruptions"},
//         {"id":"chk8003","name":"Disaster/Calamities"},
//         {"id":"chk8004","name":"Feeding Program"},
//         {"id":"chk8005","name":"Monitoring Visits"},
//         {"id":"chk8006","name":"Mother Tongue (MTB-MLE)"},
//         {"id":"chk9003","name":"GASTPE BOSY Enrolment"},
//         {"id":"chk9004","name":"Number of Slots"},
//         {"id":"chk9006","name":"GASTPE EOSY Enrolment"},
//         {"id":"chk9007","name":"GASTPE Number of Promotees/Graduates"},
//         {"id":"chk9008","name":"GASTPE Number of Dropouts"},
//         {"id":"chk9009","name":"GASTPE Number of Transferred In"},
//         {"id":"chk9010","name":"GASTPE Number of Transferred Out"},
         {"id":"chk9011","name":"Private School Personnel Data"}, //Unknown column 'priv_personnel.gemale_teachers' in 'field list'
         {"id":"chk9012","name":"Classroom and Seats"}, //Unknown column 'priv_classroomseats.ge_classroom' in 'field list'
//         {"id":"chk9013","name":"Private School Interested in Opening Senior High School"},
//         {"id":"chk9021","name":"School Building Summary"}
         ];





casper.start().eachThen(arr,function(e){
	
	
	var data=e.data;
	var id=data.id;
	casper.thenOpenAndEvaluate(URL_BASE+"user/datasets",function(){
		

	});

	
	casper.waitForSelector(".init_pro",function(){
		
	},function(){},100000);
	
	casper.thenEvaluate(function(data){
		
		var name=data.name;
		var id=data.id;
		console.log(name);
		console.log(id);
		console.log($("#"+id).parent().html());
	},e.data);
	
	casper.thenClick("#"+id,function(){
		
	});
	
	casper.waitForSelector("h4.list-group-item-heading",function(){
		this.evaluate(function(){
			
			$(".btn-primary").click();
			
		});
	});
	
	
		
	casper.waitForUrl(URL_BASE+"user/datasets#/2",function(){
		
	});
	
	casper.waitForSelector("thead",function(){
		this.evaluate(function(){
			$("#nextBtn").click();
		});
	});
	
	casper.waitForUrl(URL_BASE+"user/datasets#/3",function(){
		
	});
	
	casper.waitForSelector(".form-group",function(){
		this.evaluate(function(){
			
			$(".btn-primary").click();
			
		});
	});
	
	casper.waitForUrl(URL_BASE+"user/datasets#/4",function(){

	});
	
	casper.waitForSelector("#previewTable>tbody>tr",function(){
		
	},function(){console.log("table not found!")},50000);
	
	casper.open(URL_BASE+"user/datasets",function(){
//		this.echo("open again page 1");
	});
	
	

}).run();


