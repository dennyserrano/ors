var casper=require('casper').create({
//	verbose:true,
//	logLevel:"debug",
//	waitTimeout:50000
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

	if(resource.url.indexOf('preview')!=-1)	
		{
			console.log(JSON.stringify(resource));
		}
	
});

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
         {"id":"8","name":"School Basic Info"},
         {"id":"3","name":"Total Enrolment"},
         {"id":"4","name":"Monograde Enrolment \r\n"},
         {"id":"5","name":"Multigrade Enrolment\r\n"},
         {"id":"6","name":"Number of Balik-Aral\r\n"},
         {"id":"7","name":"CCT/4Ps Recipients\r\n"},
         {"id":"50","name":"Indigenous Peoples' Learners "},
         {"id":"51","name":"Learners in Alternative Delivery Mode (ADM) "},
         {"id":"52","name":"Learners in Arabic Language and Islamic Values Education (ALIVE) Classes"},
         {"id":"53","name":"Muslim Learners"},
         {"id":"54","name":"Number of Repeaters "},
         {"id":"55","name":"Number of Learners Previously Enrolled in Other School"},
         {"id":"56","name":"Number of Learners Previously Enrolled in Other Public School"},
         {"id":"57","name":"Number of Learners Previously Enrolled in Private"},
         {"id":"58","name":"End-of-School Year Enrollment "},
         {"id":"59","name":"Number of Graduates"},
         {"id":"60","name":"Number of Completers/Promotees"},
         {"id":"61","name":"Number of Dropouts"},
         {"id":"62","name":"Number of Transferees-In"},
         {"id":"63","name":"Number of Transferees Out"},
         {"id":"64","name":"Number of Late Enrollees"},
         {"id":"65","name":"Number of Continuing Learners"},
         {"id":"68","name":"Distance Education (DistEd) for SPED"},
         {"id":"69","name":"Enhanced Instructional Management by Parents, Community and Teachers (e-IMPACT)"},
         {"id":"70","name":"Modified In-School Off-School Approach (MISOSA)"},
         {"id":"71","name":"Other School-Initiated Interventions"},
         {"id":"72","name":"Open High School Program (OHSP)"},
         {"id":"119","name":"SPED Graded"},
         {"id":"120","name":"Madrasah Education"},
         {"id":"121","name":"Children Living Far from School"},
         {"id":"122","name":"Street Children"},
         {"id":"125","name":"Total Enrolment in Kinder Summer Program"},
         {"id":"126","name":"Enrolment By Age in Kinder Summer Program"},
         {"id":"127","name":"Total Enrolment in ALS"},
         {"id":"128","name":"Enrolment By Age in ALS"},
         {"id":"1002","name":"Total Enrolment By Age in Elementary Schools"},
         {"id":"1003","name":"Enrolment By Age in Elementary"}, //LONG PROCESS
         {"id":"1004","name":"Enrolment By Age in Kindergarten"},
         {"id":"1005","name":"Enrolment By Age in Grade 1"},
         {"id":"1006","name":"Enrolment By Age in Non-graded"},
         {"id":"1007","name":"Total Enrolment By Age in Secondary Schools"},
         {"id":"1008","name":"Enrolment By Age in Secondary"},
         {"id":"1009","name":"Enrolment By Age in Secondary Non-graded"}, //error You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '-graded ON sp.school_year = age_ssnon-graded.sy_from AND sp.school_id = age_ssno' at line 1
         {"id":"1501","name":"School Site Data"},
         {"id":"2003","name":"Total Enrolment By Area of Exceptionality"},
         {"id":"2004","name":"Learners with Learning Disability"},
         {"id":"2005","name":"Learners with Hearing Impairment"},
         {"id":"2006","name":"Learners with Visual Impairment - Blindness"},
         {"id":"2007","name":"Learners with Visual Impairment - Low Vision"},
         {"id":"2008","name":"Learners with Intellectual Disability/Mental Retardation"},
         {"id":"2009","name":"Learners with Multiple Handicap"},
         {"id":"2010","name":"Learners with Behavioral Problem"},
         {"id":"2011","name":"Learners with Orthopedic Handicap"},
         {"id":"2012","name":"Learners with Autism"},
         {"id":"2013","name":"Learners with Communication Disorder"},
         {"id":"2014","name":"Learners with Cerebral Palsy"},
         {"id":"2015","name":"Learners with Special Health Problem"},
         {"id":"2016","name":"Gifted/Fast Learners"},
         {"id":"2018","name":"Total Gifted and Talented Learners Data"},
         {"id":"2020","name":"Visual Impairment"}, //error SPED table
         {"id":"2021","name":"Hearing Impairment"}, 
         {"id":"2022","name":"Learning Disability"},
         {"id":"2023","name":"Intellectual Disability"},
         {"id":"2024","name":"Autism Spectrum Disorder\r\n"},
         {"id":"2025","name":"Emotional-Behavioral Disorder\r\n"}, //error SPED table
         {"id":"2026","name":"Orthopedic/Physical Handicap\r\n"}, //error SPED table
         {"id":"2027","name":"Speech/Language Disorder\r\n"},
         {"id":"2028","name":"Cerebral Palsy\r\n"},
         {"id":"2029","name":"Special Health Problem/Chronic Illness\r\n"},
         {"id":"2030","name":"Multiple Disabilities\r\n"}, //error SPED table
         {"id":"2032","name":"Difficulty Seeing\r\n"},
         {"id":"2033","name":"Difficulty Hearing\r\n"},
         {"id":"2034","name":"Difficulty Walking, Climbing and Grasping"},
         {"id":"2035","name":"Difficulty Remembering, Concentrating, Paying Attention and Understanding"},
         {"id":"2036","name":"Difficulty Communicating"},
         {"id":"2040","name":"Visual Impairment (Non-graded)"}, //error SPED table
         {"id":"2041","name":"Hearing Impairment (Non-graded)"}, //error SPED table
         {"id":"2042","name":"Learning Disability (Non-graded)"},
         {"id":"2043","name":"Intellectual Disability (Non-graded)"},
         {"id":"2044","name":"Autism Spectrum Disorder (Non-graded)"},
         {"id":"2045","name":"Emotional-Behavioral Disorder (Non-graded)"},
         {"id":"2046","name":"Orthopedic/Physical Handicap (Non-graded)"},
         {"id":"2047","name":"Speech/Language Disorder (Non-graded)"},
         {"id":"2048","name":"Cerebral Palsy (Non-graded)"}, //error SPED table
         {"id":"2049","name":"Special Health Problem/Chronic Illness  (Non-graded)"}, //error SPED table
         {"id":"2050","name":"Multiple Disabilities (Non-graded)"},
         {"id":"2051","name":"Multiple Disability with Visual Impairment (Non-graded)\r\n"},
         {"id":"2038","name":"Total Non-graded Learners with Exceptionalities"},
         {"id":"2053","name":"Difficulty Seeing (Non-graded)"},
         {"id":"2054","name":"Difficulty Hearing (Non-graded)"}, //error SPED table
         {"id":"2055","name":"Difficulty Walking, Climbing and Grasping (Non-graded)"},
         {"id":"2056","name":"Difficulty Remembering, Concentrating, Paying Attention and Understanding (Non-graded)"},
         {"id":"2057","name":"Difficulty Communicating (Non-graded)"},
         {"id":"2059","name":"Total Leaners from SPED Classes or SPED Centers Mainstreamed in Regular Class"},
         {"id":"2061","name":"Visual Impairment (Mainstreamed)"},
         {"id":"2062","name":"Hearing Impairment (Mainstreamed)"}, //error SPED table
         {"id":"2063","name":"Learning Disability (Mainstreamed)"},
         {"id":"2064","name":"Intellectual Disability (Mainstreamed)"},
         {"id":"2065","name":"Autism Spectrum Disorder (Mainstreamed)"},
         {"id":"2066","name":"Emotional-Behavioral Disorder (Mainstreamed)"},
         {"id":"2067","name":"Orthopedic/Physical Handicap (Mainstreamed)"},
         {"id":"2068","name":"Speech/Language Disorder (Mainstreamed)"},
         {"id":"2069","name":"Cerebral Palsy (Mainstreamed)"},
         {"id":"2070","name":"Special Health Problem/Chronic Illness  (Mainstreamed)"},
         {"id":"2071","name":"Multiple Disabilities (Mainstreamed)"},
         {"id":"2072","name":"Multiple Disability with Visual Impairment (Mainstreamed)\r\n"},
         {"id":"2074","name":"Difficulty Seeing (Mainstreamed)"},
         {"id":"2075","name":"Difficulty Hearing (Mainstreamed)"},
         {"id":"2076","name":"Difficulty Walking, Climbing and Grasping (Mainstreamed)"},
         {"id":"2077","name":"Difficulty Remembering, Concentrating, Paying Attention and Understanding (Mainstreamed)"}, //error SPED table
         {"id":"2078","name":"Difficulty Communicating (Mainstreamed)"},
         {"id":"2080","name":"Total Learners with Exceptionalities Who Did Not Attend Any SPED Class"},
         {"id":"2081","name":"Visual Impairment (Did Not Attend Any SPED Class)"},
         {"id":"2082","name":"Hearing Impairment (Did Not Attend Any SPED Class)"},
         {"id":"2083","name":"Learning Disability (Did Not Attend Any SPED Class)"},
         {"id":"2084","name":"Intellectual Disability (Did Not Attend Any SPED Class)"},
         {"id":"2085","name":"Autism Spectrum Disorder (Did Not Attend Any SPED Class)"}, //error SPED table
         {"id":"2086","name":"Emotional-Behavioral Disorder (Did Not Attend Any SPED Class)"}, //error SPED table
         {"id":"2087","name":"Orthopedic/Physical Handicap (Did Not Attend Any SPED Class)"},
         {"id":"2088","name":"Speech/Language Disorder (Did Not Attend Any SPED Class)"}, //error SPED table
         {"id":"2089","name":"Cerebral Palsy (Did Not Attend Any SPED Class)"}, //error SPED table
         {"id":"2090","name":"Special Health Problem/Chronic Illness  (Did Not Attend Any SPED Class)"},
         {"id":"2091","name":"Multiple Disabilities (Did Not Attend Any SPED Class)"}, //error SPED table
         {"id":"2092","name":"Multiple Disability with Visual Impairment (Did Not Attend Any SPED Class)"},
         {"id":"3003","name":"Total Enrolment By Program in Elementary"},
         {"id":"3004","name":"Enrolment in ALIVE"},
         {"id":"3005","name":"Enrolment in SSES"},
         {"id":"3007","name":"Total Enrolment By Program in Secondary Schools"},
         {"id":"3008","name":"Enrolment in ALIVE in Secondary Schools"},
         {"id":"3009","name":"Enrolment in Division Science High School"},
         {"id":"3010","name":"Enrolment in ESEP"},
         {"id":"3011","name":"Enrolment in Philippine High School for the Arts"},
         {"id":"3012","name":"Enrolment in Regional Science High School"},
         {"id":"3013","name":"Enrolment in Regular Curriculum"},
         {"id":"3014","name":"Enrolment in Regular Curriculum in Schools Offering Regular and Special Programs"},
         {"id":"3015","name":"Enrolment in Special Program in the Arts"},
         {"id":"3016","name":"Enrolment in Special Program in Foreign Language"},
         {"id":"3017","name":"Enrolment in Special Program in Journalism"},
         {"id":"3018","name":"Enrolment in Special Program in Science, Technology and Engineering"},
         {"id":"3019","name":"Enrolment in Special Program in Sports"},
         {"id":"3020","name":"Enrolment in Special Program in Technical Vocational Education"},
         {"id":"3021","name":"Enrolment in Special Program in Technical Vocational - Agriculture"},
         {"id":"3022","name":"Enrolment in Special Program in Technical Vocational - Arts and Trade"},
         {"id":"3023","name":"Enrolment in Special Program in Technical Vocational - Fishery"},
         {"id":"3024","name":"Enrolment in Special Program in Technical Vocational - ICT"},
         {"id":"3025","name":"Enrolment in SPED in Schools Offering Regular with Special Program"},
         {"id":"3026","name":"Enrolment in SPED in Schools Offering Special Program"},
         {"id":"3027","name":"Enrolment in Technical Vocational - Agriculture in Schools Offering Special Program"},
         {"id":"3028","name":"Enrolment in Technical Vocational - Arts and Trade in Schools Offering Special Program"},
         {"id":"3029","name":"Enrolment in Technical Vocational - Fishery in Schools Offering Special Program"},
         {"id":"3502","name":"TLE Total Enrolment By Subject"},
         {"id":"3503","name":"TLE Enrolment in Home Economics"},
         {"id":"3504","name":"TLE Enrolment in Agri-Fishery Arts"},
         {"id":"3505","name":"TLE Enrolment in Industrial Arts"},
         {"id":"3506","name":"TLE Enrolment in Information and Communication Technology (ICT)"},
         {"id":"4002","name":"Total Number of Dropout By Grade Level"},
         {"id":"4003","name":"Total Number of Dropouts By Cause"},
         {"id":"4004","name":"Number of Dropouts Caused By Domestic/Family-Related Factors"},
         {"id":"4005","name":"Number of Dropouts Caused By Individual-Related Factors"},
         {"id":"4006","name":"Number of Dropouts Caused By School-Related Factors"},
         {"id":"4007","name":"Number of Dropouts Caused By Geographical/Environmental Factors"},
         {"id":"4008","name":"Number of Dropouts Caused By Financial-Related Factors and Others"},
         {"id":"5001","name":"Teaching Personnel"},
         {"id":"5002","name":"Non-Teaching Personnel"},
         {"id":"5004","name":"Locally-funded Personnel"},
         {"id":"5005","name":"Personnel By Grade Level"},
         {"id":"5006","name":"Number of  Teachers by Teaching Assignment and by Area of Specialization"},
         {"id":"5007","name":"Number of Teachers By Residence"},
         {"id":"6002","name":"Total Instructional Rooms"},
         {"id":"6004","name":"Total Standard Instructional Rooms"},
         {"id":"6005","name":"Standard Complete Instructional Rooms"},
         {"id":"6006","name":"Standard Incomplete Instructional Rooms"},
         {"id":"6007","name":"Non-Standard / Makeshift Rooms"},
         {"id":"6009","name":"Total Non-instructional Rooms"},
         {"id":"6010","name":"Complete Non-instructional Rooms"},
         {"id":"6011","name":"Incomplete Non-instructional Rooms"},
         {"id":"6014","name":"Total Number of Existing Rooms By Fund Source"},
         {"id":"6015","name":"Number of Existing Instructional Rooms By Fund Source"},
         {"id":"6016","name":"Number of Existing Other Instructional Rooms By Fund Source"},
         {"id":"6017","name":"Number of Existing Non-instructional Rooms By Fund Source"},
         {"id":"6019","name":"Total Number of Rooms On-going Construction By Fund Source"},
         {"id":"6020","name":"Number of Instructional Rooms On-going Construction By Fund Source"},
         {"id":"6021","name":"Number of Non-instructional Rooms On-going Construction By Fund Source"},
         {"id":"6022","name":"Rooms Needing Repair"},
		 {"id":"6023","name":"Buildable Space"},
         {"id":"6024","name":"Makeshift, Condemned and Condemnable"},
         {"id":"6025","name":"Class Furniture"},
         {"id":"6026","name":"Toilets and Urinals"},
         {"id":"6501","name":"Water Supply"},
         {"id":"6502","name":"Electrical Supply"},
         {"id":"7002","name":"Total Number of Computers By Fund Source"},
         {"id":"7004","name":"Total Number of Computers for Academic Use"},
         {"id":"7005","name":"Number of Desktop/Notebook/Netbook/Tablet for Academic Use"},
         {"id":"7006","name":"Number of Desktop Virtual Terminal for Academic Use"},
         {"id":"7007","name":"Number of Desktop Computers Academic Use "},
         {"id":"7008","name":"Number of Notebook Computers for Academic Use"},
         {"id":"7009","name":"Number of Tablet Computers for Academic Use"},
         {"id":"7011","name":"Total Number of Computers for Administrative Use"},
         {"id":"7012","name":"Number of Desktop/Notebook/Netbook/Tablet for Administrative Use"},
         {"id":"7013","name":"Number of Desktop Virtual Terminal for Administrative Use"},
         {"id":"7014","name":"Number of Desktop Computers Administrative Use "},
         {"id":"7015","name":"Number of Notebook Computers for Administrative Use"},
         {"id":"7016","name":"Number of Tablet Computers for Administrative Use"},
         {"id":"7018","name":"Total Number of Computers Needing Repair"},
         {"id":"7019","name":"Number of Desktop/Notebook/Netbook/Tablet Computers Needing Repair"},
         {"id":"7020","name":"Number of Desktop Virtual Terminal Needing Repair"},
         {"id":"7023","name":"Wired"},
         {"id":"7024","name":"Fixed Wireless"},
         {"id":"7025","name":"Satellite"},
         {"id":"7026","name":"USB Modem"},
         {"id":"7028","name":"Wired Connection By Fund Source"},
         {"id":"7029","name":"Fixed Wireless Connection By Fund Source"},
         {"id":"7030","name":"Satellite Connection By Fund Source"},
         {"id":"7031","name":"USB Modem Connection By Fund Source'"},
         {"id":"7032","name":"Availability of Internet Connection and ISP"},
         {"id":"7033","name":"Availability of Cellphone Network"},
         {"id":"7034","name":"Internet Connection By ISP and Fund Source"},
         {"id":"8001","name":"Agriculture and Fishery Resources"},
         {"id":"8002","name":"Class Disruptions"},
         {"id":"8003","name":"Disaster/Calamities"},
         {"id":"8004","name":"Feeding Program"},
         {"id":"8005","name":"Monitoring Visits"},
         {"id":"8006","name":"Mother Tongue (MTB-MLE)"}, //error ColumnElement
         {"id":"9003","name":"GASTPE BOSY Enrolment"},
         {"id":"9004","name":"Number of Slots"},
         {"id":"9006","name":"GASTPE EOSY Enrolment"},
         {"id":"9007","name":"GASTPE Number of Promotees/Graduates"},
         {"id":"9008","name":"GASTPE Number of Dropouts"},
         {"id":"9009","name":"GASTPE Number of Transferred In"},
         {"id":"9010","name":"GASTPE Number of Transferred Out"},
         {"id":"9011","name":"Private School Personnel Data"}, //Unknown column 'priv_personnel.gemale_teachers' in 'field list'
         {"id":"9012","name":"Classroom and Seats"},
         {"id":"9013","name":"Private School Interested in Opening Senior High School"},
         {"id":"9021","name":"School Building Summary"}
         ];

    //block 34  Unknown column 'en_kindersummerage.g1ecdtotAge9' in 'on clause'
//block 35 error
//block 36 hang on page 2 next
function group(array)
	{
		var finalArr=[];
		
		for(var x=34;x<array.length;x++)
		{
			var blockProfile={};
			blockProfile.blockId=x;
			blockProfile.data=[];
			for(var y=0;y<=x;y++)
			{
				blockProfile.data.push(array[y]);
			}
			finalArr.push(blockProfile);
		}
		return finalArr;
	}
	
	arr=group(arr);


	casper.start().eachThen(arr,function(e){
		
		var block=e.data;
		var blockData=e.data.data;
		
		casper.thenOpenAndEvaluate(URL_BASE+"user/datasets",function(block){
			
			console.log("BlockId:"+block.blockId);
			
			
			var blockData=block.data;

		},block);
		
		casper.waitForSelector("#sidemenu-container>ul>li",function(){
			
		},function(){console.log("WAIT TIMEOUT: sidemenu not shown!");});
		
		
		
		blockData.forEach(function(item,index){
			var id=item.id;
			var name=item.name;
			
			casper.thenClick("#chk"+id,function(){
				console.log("I clicked:"+name);
			});
		});
		
		
		
		blockData.forEach(function(item,index){
			
			var name=item.name;
			var id=item.id;
			casper.waitForText(name,function(){
				
			},function(){console.log("WAIT TIMEOUT: wait for text");});
			
			casper.waitForSelector("#elements"+id,function(){
				
			},function(){console.log("WAIT TIMEOUT: wait for selector: #elements");});
			
		});
	
		
		casper.thenEvaluate(function(){
			
			$(".btn-primary").click();
		})
		
		casper.waitForUrl(URL_BASE+"user/datasets#/2",function(){
			
			
		},function(){console.log("WAIT TIMEOUT: page 2 not shown!");});
		
		casper.waitForSelector("#elementsTable>tbody>tr>td",function(){
			
		},function(){console.log("WAIT TIMEOUT: thead not shown!");});
		
	
		casper.thenClick(".btn-primary",function(){
			
//			console.log("next button clicked! p(2)");
		});
		
		
		casper.waitForUrl(URL_BASE+"user/datasets#/3",function(){
			
		},function(){console.log("WAIT TIMEOUT: page 3 not shown!");});
		
		casper.waitForSelector(".form-group",function(){
			this.evaluate(function(){
				
//				console.log("next button clicked! p(3)");
				$(".btn-primary").click();
				
			});
		});
		
		casper.waitForUrl(URL_BASE+"user/datasets#/4",function(){

		},function(){console.log("WAIT TIMEOUT: page 4 not shown!");});
		
		casper.waitForSelector("#previewTable>tbody>tr",function(){
			
		},function(){console.log("WAIT TIMEOUT: table not found!");});
		
		casper.open(URL_BASE+"user/datasets",function(){
//			this.echo("open again page 1");
		});
	}).run();



