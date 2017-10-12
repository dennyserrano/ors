package ph.gov.deped;

import java.util.ArrayList;


public class ParseTest {
	
	public static void main(String[] args) {
		String input="g11male_TOT,g11female_TOT,g12male_TOT,g12female_TOT,gmale_TOT_ATPOE,gfemale_TOT_ATPOE,TOT_ATPOE,gmale_TOT_BARB,gfemale_TOT_BARB,TOT_BARB,gmale_TOT_BART,gfemale_TOT_BART,TOT_BART,gmale_TOT_BNC,gfemale_TOT_BNC,TOT_BNC,gmale_TOT_BNP,gfemale_TOT_BNP,TOT_BNP,gmale_TOT_CGV,gfemale_TOT_CGV,TOT_CGV,gmale_TOT_CC,gfemale_TOT_CC,TOT_CC,gmale_TOT_COOK,gfemale_TOT_COOK,TOT_COOK,gmale_TOT_DRESS,gfemale_TOT_DRESS,TOT_DRESS,gmale_TOT_EMS,gfemale_TOT_EMS,TOT_EMS,gmale_TOT_FD,gfemale_TOT_FD,TOT_FD,gmale_TOT_FBS,gfemale_TOT_FBS,TOT_FBS,gmale_TOT_FOS,gfemale_TOT_FOS,TOT_FOS,gmale_TOT_HDII,gfemale_TOT_HDII,TOT_HDII,gmale_TOT_HDIII,gfemale_TOT_HDIII,TOT_HDIII,gmale_TOT_HBM,gfemale_TOT_HBM,TOT_HBM,gmale_TOT_HFAP,gfemale_TOT_HFAP,TOT_HFAP,gmale_TOT_HN,gfemale_TOT_HN,TOT_HN,gmale_TOT_HWL,gfemale_TOT_HWL,TOT_HWL,gmale_TOT_HK,gfemale_TOT_HK,TOT_HK,gmale_TOT_LGS,gfemale_TOT_LGS,TOT_LGS,gmale_TOT_TLOR,gfemale_TOT_TLOR,TOT_TLOR,gmale_TOT_TPS,gfemale_TOT_TPS,TOT_TPS,gmale_TOT_TS,gfemale_TOT_TS,TOT_TS,gmale_TOT_WM,gfemale_TOT_WM,TOT_WM,gmale_TOT_ACPI,gfemale_TOT_ACPI,TOT_ACPI,gmale_TOT_ACPII,gfemale_TOT_ACPII,TOT_ACPII,gmale_TOT_ACPIII,gfemale_TOT_ACPIII,TOT_ACPIII,gmale_TOT_AHCM,gfemale_TOT_AHCM,TOT_AHCM,gmale_TOT_APPC,gfemale_TOT_APPC,TOT_APPC,gmale_TOT_APLR,gfemale_TOT_APLR,TOT_APLR,gmale_TOT_APS,gfemale_TOT_APS,TOT_APS,gmale_TOT_AQUA,gfemale_TOT_AQUA,TOT_AQUA,gmale_TOT_AILR,gfemale_TOT_AILR,TOT_AILR,gmale_TOT_AIS,gfemale_TOT_AIS,TOT_AIS,gmale_TOT_FC,gfemale_TOT_FC,TOT_FC,gmale_TOT_FGRM,gfemale_TOT_FGRM,TOT_FGRM,gmale_TOT_FPP,gfemale_TOT_FPP,TOT_FPP,gmale_TOT_FWO,gfemale_TOT_FWO,TOT_FWO,gmale_TOT_FP,gfemale_TOT_FP,TOT_FP,gmale_TOT_HORT,gfemale_TOT_HORT,TOT_HORT,gmale_TOT_LIM,gfemale_TOT_LIM,TOT_LIM,gmale_TOT_OA,gfemale_TOT_OA,TOT_OA,gmale_TOT_PM,gfemale_TOT_PM,TOT_PM,gmale_TOT_RMO,gfemale_TOT_RMO,TOT_RMO,gmale_TOT_RP,gfemale_TOT_RP,TOT_RP,gmale_TOT_RUBPROD,gfemale_TOT_RUBPROD,TOT_RUBPROD,gmale_TOT_SO,gfemale_TOT_SO,TOT_SO,gmale_TOT_ASI,gfemale_TOT_ASI,TOT_ASI,gmale_TOT_ASII,gfemale_TOT_ASII,TOT_ASII,gmale_TOT_CARTII,gfemale_TOT_CARTII,TOT_CARTII,gmale_TOT_CARTIII,gfemale_TOT_CARTIII,TOT_CARTIII,gmale_TOT_CP,gfemale_TOT_CP,TOT_CP,gmale_TOT_DOMRAC,gfemale_TOT_DOMRAC,TOT_DOMRAC,gmale_TOT_EIM,gfemale_TOT_EIM,TOT_EIM,gmale_TOT_EPDLC,gfemale_TOT_EPDLC,TOT_EPDLC,gmale_TOT_EPAS,gfemale_TOT_EPAS,TOT_EPAS,gmale_TOT_FM,gfemale_TOT_FM,TOT_FM,gmale_TOT_ICS,gfemale_TOT_ICS,TOT_ICS,gmale_TOT_GMAW,gfemale_TOT_GMAW,TOT_GMAW,gmale_TOT_GTAW,gfemale_TOT_GTAW,TOT_GTAW,gmale_TOT_MACHI,gfemale_TOT_MACHI,TOT_MACHI,gmale_TOT_MACHII,gfemale_TOT_MACHII,TOT_MACHII,gmale_TOT_MSN,gfemale_TOT_MSN,TOT_MSN,gmale_TOT_MS,gfemale_TOT_MS,TOT_MS,gmale_TOT_SES,gfemale_TOT_SES,TOT_SES,gmale_TOT_PLUMI,gfemale_TOT_PLUMI,TOT_PLUMI,gmale_TOT_PLUMII,gfemale_TOT_PLUMII,TOT_PLUMII,gmale_TOT_PACU,gfemale_TOT_PACU,TOT_PACU,gmale_TOT_SMAWI,gfemale_TOT_SMAWI,TOT_SMAWI,gmale_TOT_SMAWII,gfemale_TOT_SMAWII,TOT_SMAWII,gmale_TOT_TILE,gfemale_TOT_TILE,TOT_TILE,gmale_TOT_TLIM,gfemale_TOT_TLIM,TOT_TLIM,gmale_TOT_ANIM,gfemale_TOT_ANIM,TOT_ANIM,gmale_TOT_FWS,gfemale_TOT_FWS,TOT_FWS,gmale_TOT_CPNT,gfemale_TOT_CPNT,TOT_CPNT,gmale_TOT_CPJV,gfemale_TOT_CPJV,TOT_CPJV,gmale_TOT_CPOR,gfemale_TOT_CPOR,TOT_CPOR,gmale_TOT_CSS,gfemale_TOT_CSS,TOT_CSS,gmale_TOT_CCS,gfemale_TOT_CCS,TOT_CCS,gmale_TOT_ILLUS,gfemale_TOT_ILLUS,TOT_ILLUS,gmale_TOT_MT,gfemale_TOT_MT,TOT_MT,gmale_TOT_TD,gfemale_TOT_TD,TOT_TD,gmale_TOT_CCPD,gfemale_TOT_CCPD,TOT_CCPD,gmale_TOT_FOC,gfemale_TOT_FOC,TOT_FOC,gmale_TOT_NW1,gfemale_TOT_NW1,TOT_NW1,gmale_TOT_NW2,gfemale_TOT_NW2,TOT_NW2,gmale_TOT_NW3,gfemale_TOT_NW3,TOT_NW3,gmale_TOT_EW1,gfemale_TOT_EW1,TOT_EW1,gmale_TOT_EW2,gfemale_TOT_EW2,TOT_EW2,gmale_TOT_SFTY1,gfemale_TOT_SFTY1,TOT_SFTY1,gmale_TOT_SFTY2,gfemale_TOT_SFTY2,TOT_SFTY2,gmale_TOT_SCS,gfemale_TOT_SCS,TOT_SCS,total";
		String[] arr=input.split(",");
		
		for(String a:arr)
			System.out.println(String.format("%s=VALUES(%s),", a,a));
		
	}
	
	
//	public static void main(String[] args) {
//	
//	String[][] a=new String[][]{
//			{"g11maleNW1","Grade 11 Male Navigational Watch 1"},
//			{"g11femaleNW1","Grade 11 Female Navigational Watch 1"},
//			{"g11_TOTNW1","Grade 11 Total Navigational Watch 1"},
//			{"g12maleNW1","Grade 12 Male Navigational Watch 1"},
//			{"g12femaleNW1","Grade 12 Female Navigational Watch 1"},
//			{"g12_TOTNW1","Grade 12 Total Navigational Watch 1"},
//			{"gmaleNW1","Total Male for Navigational Watch 1"},
//			{"gfemaleNW1","Total Female for Navigational Watch 1"},
//			{"TOT_NW1","Total Navigational Watch 1"},
//			{"g11male_NW2","Grade 11 Male Navigational Watch 2"},
//			{"g11female_NW2","Grade 11 Female Navigational Watch 2"},
//			{"g11_TOT_NW2","Grade 11 Total Navigational Watch 2"},
//			{"g12male_NW2","Grade 12 Male Navigational Watch 2"},
//			{"g12female_NW2","Grade 12 Female Navigational Watch 2"},
//			{"g12_TOT_NW2","Grade 12 Total Navigational Watch 2"},
//			{"gmale_TOT_NW2","Total Male for Navigational Watch 2"},
//			{"gfemale_TOT_NW2","Total Female for Navigational Watch 2"},
//			{"TOT_NW2","Total Navigational Watch 2"},
//			{"g11male_NW3","Grade 11 Male Navigational Watch 3"},
//			{"g11female_NW3","Grade 11 Female Navigational Watch 3"},
//			{"g11_TOT_NW3","Grade 11 Total Navigational Watch 3"},
//			{"g12male_NW3","Grade 12 Male Navigational Watch 3"},
//			{"g12female_NW3","Grade 12 Female Navigational Watch 3"},
//			{"g12_TOT_NW3","Grade 12 Total Navigational Watch 3"},
//			{"gmale_TOT_NW3","Total Male for Navigational Watch 3"},
//			{"gfemale_TOT_NW3","Total Female for Navigational Watch 3"},
//			{"TOT_NW3","Total Navigational Watch 3"},
//			{"g11male_EW1","Grade 11 Male Engine Watch 1"},
//			{"g11female_EW1","Grade 11 Female Engine Watch 1"},
//			{"g11_TOT_EW1","Grade 11 Total Engine Watch 1"},
//			{"g12male_EW1","Grade 12 Male Engine Watch 1"},
//			{"g12female_EW1","Grade 12 Female Engine Watch 1"},
//			{"g12_TOT_EW1","Grade 12 Total Engine Watch 1"},
//			{"gmale_TOT_EW1","Total Male for Engine Watch 1"},
//			{"gfemale_TOT_EW1","Total Female for Engine Watch 1"},
//			{"TOT_EW1","Total Engine Watch 1"},
//			{"g11male_EW2","Grade 11 Male Engine Watch 2"},
//			{"g11female_EW2","Grade 11 Female Engine Watch 2"},
//			{"g11_TOT_EW2","Grade 11 Total Engine Watch 2"},
//			{"g12male_EW2","Grade 12 Male Engine Watch 2"},
//			{"g12female_EW2","Grade 12 Female Engine Watch 2"},
//			{"g12_TOT_EW2","Grade 12 Total Engine Watch 2"},
//			{"gmale_TOT_EW2","Total Male for Engine Watch 2"},
//			{"gfemale_TOT_EW2","Total Female for Engine Watch 2"},
//			{"TOT_EW2","Total Engine Watch 2"},
//			{"g11male_SFTY1","Grade 11 Male Safety 1"},
//			{"g11female_SFTY1","Grade 11 Female Safety 1"},
//			{"g11_TOT_SFTY1","Grade 11 Total Safety 1"},
//			{"g12male_SFTY1","Grade 12 Male Safety 1"},
//			{"g12female_SFTY1","Grade 12 Female Safety 1"},
//			{"g12_TOT_SFTY1","Grade 12 Total Safety 1"},
//			{"gmale_TOT_SFTY1","Total Male for Safety 1"},
//			{"gfemale_TOT_SFTY1","Total Female for Safety 1"},
//			{"TOT_SFTY1","Total Safety 1"},
//			{"g11male_SFTY2","Grade 11 Male Safety 2"},
//			{"g11female_SFTY2","Grade 11 Female Safety 2"},
//			{"g11_TOT_SFTY2","Grade 11 Total Safety 2"},
//			{"g12male_SFTY2","Grade 12 Male Safety 2"},
//			{"g12female_SFTY2","Grade 12 Female Safety 2"},
//			{"g12_TOT_SFTY2","Grade 12 Total Safety 2"},
//			{"gmale_TOT_SFTY2","Total Male for Safety 2"},
//			{"gfemale_TOT_SFTY2","Total Female for Safety 2"},
//			{"TOT_SFTY2","Total Safety 2"},
//			{"g11male_SCS","Grade 11 Male Ship’s Catering Services (NC I)"},
//			{"g11female_SCS","Grade 11 Female Ship’s Catering Services (NC I)"},
//			{"g11_TOT_SCS","Grade 11 Total Ship’s Catering Services (NC I)"},
//			{"g12male_SCS","Grade 12 Male Ship’s Catering Services (NC I)"},
//			{"g12female_SCS","Grade 12 Female Ship’s Catering Services (NC I)"},
//			{"g12_TOT_SCS","Grade 12 Total Ship’s Catering Services (NC I)"},
//			{"gmale_TOT_SCS","Total Male for Ship’s Catering Services (NC I)"},
//			{"gfemale_TOT_SCS","Total Female for Ship’s Catering Services (NC I)"},
//			{"TOT_SCS","Total Ship’s Catering Services (NC I)"}
//			
//	};
//	String strRef="INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) \n"
//			+ "VALUES(@table_id,'%s','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); \n \n"
//			+ "INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) \n"
//			+ "VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','%s','%s','%s',@dataset_head_id,1); \n \n";
//	
//	
//	for(int x=0;x<a.length;x++)
//	{
//		String c1=a[x][0];
//		String c2=a[x][1];
//		System.out.println(String.format(strRef, c1,c1,c2,c2));
//	}
//	
//}

//public static void main(String[] args) {
//	String input="gmaleNW1,gfemaleNW1,TOT_NW1,gmale_TOT_NW2,gfemale_TOT_NW2,TOT_NW2,gmale_TOT_NW3,gfemale_TOT_NW3,TOT_NW3,gmale_TOT_EW1,gfemale_TOT_EW1,TOT_EW1,gmale_TOT_EW2,gfemale_TOT_EW2,TOT_EW2,gmale_TOT_SFTY1,gfemale_TOT_SFTY1,TOT_SFTY1,gmale_TOT_SFTY2,gfemale_TOT_SFTY2,TOT_SFTY2,gmale_TOT_SCS,gfemale_TOT_SCS,TOT_SCS";
//	String input2="Total Male for Navigational Watch 1,Total Female for Navigational Watch 1,Total Navigational Watch 1,Total Male for Navigational Watch 2,Total Female for Navigational Watch 2,Total Navigational Watch 2,Total Male for Navigational Watch 3,Total Female for Navigational Watch 3,Total Navigational Watch 3,Total Male for Engine Watch 1,Total Female for Engine Watch 1,Total Engine Watch 1,Total Male for Engine Watch 2,Total Female for Engine Watch 2,Total Engine Watch 2,Total Male for Safety 1,Total Female for Safety 1,Total Safety 1,Total Male for Safety 2,Total Female for Safety 2,Total Safety 2,Total Male for Ship’s Catering Services (NC I),Total Female for Ship’s Catering Services (NC I),Total Ship’s Catering Services (NC I)";
//	String[] parse1=input.split(",");
//	String[] parse2=input2.split(",");
//	
//	for(int x=0;x<parse1.length;x++)
//	{
//		String p1=parse1[x];
//		String p2=parse2[x];
//		String f="{\"%s\",\"%s\"},";
//		System.out.println(String.format(f, p1,p2));
//	}
//	
//}


//	public static void main(String[] args) {
//		
//		String[][] a=new String[][]{
//				{"g11maleNW1","Grade 11 Male Navigational Watch 1"},
//				{"g11femaleNW1","Grade 11 Female Navigational Watch 1"},
//				{"g11_TOTNW1","Grade 11 Total Navigational Watch 1"},
//				{"g12maleNW1","Grade 12 Male Navigational Watch 1"},
//				{"g12femaleNW1","Grade 12 Female Navigational Watch 1"},
//				{"g12_TOTNW1","Grade 12 Total Navigational Watch 1"},
//				{"g11male_NW2","Grade 11 Male Navigational Watch 2"},
//				{"g11female_NW2","Grade 11 Female Navigational Watch 2"},
//				{"g11_TOT_NW2","Grade 11 Total Navigational Watch 2"},
//				{"g12male_NW2","Grade 12 Male Navigational Watch 2"},
//				{"g12female_NW2","Grade 12 Female Navigational Watch 2"},
//				{"g12_TOT_NW2","Grade 12 Total Navigational Watch 2"},
//				{"g11male_NW3","Grade 11 Male Navigational Watch 3"},
//				{"g11female_NW3","Grade 11 Female Navigational Watch 3"},
//				{"g11_TOT_NW3","Grade 11 Total Navigational Watch 3"},
//				{"g12male_NW3","Grade 12 Male Navigational Watch 3"},
//				{"g12female_NW3","Grade 12 Female Navigational Watch 3"},
//				{"g12_TOT_NW3","Grade 12 Total Navigational Watch 3"},
//				{"g11male_EW1","Grade 11 Male Engine Watch 1"},
//				{"g11female_EW1","Grade 11 Female Engine Watch 1"},
//				{"g11_TOT_EW1","Grade 11 Total Engine Watch 1"},
//				{"g12male_EW1","Grade 12 Male Engine Watch 1"},
//				{"g12female_EW1","Grade 12 Female Engine Watch 1"},
//				{"g12_TOT_EW1","Grade 12 Total Engine Watch 1"},
//				{"g11male_EW2","Grade 11 Male Engine Watch 2"},
//				{"g11female_EW2","Grade 11 Female Engine Watch 2"},
//				{"g11_TOT_EW2","Grade 11 Total Engine Watch 2"},
//				{"g12male_EW2","Grade 12 Male Engine Watch 2"},
//				{"g12female_EW2","Grade 12 Female Engine Watch 2"},
//				{"g12_TOT_EW2","Grade 12 Total Engine Watch 2"},
//				{"g11male_SFTY1","Grade 11 Male Safety 1"},
//				{"g11female_SFTY1","Grade 11 Female Safety 1"},
//				{"g11_TOT_SFTY1","Grade 11 Total Safety 1"},
//				{"g12male_SFTY1","Grade 12 Male Safety 1"},
//				{"g12female_SFTY1","Grade 12 Female Safety 1"},
//				{"g12_TOT_SFTY1","Grade 12 Total Safety 1"},
//				{"g11male_SFTY2","Grade 11 Male Safety 2"},
//				{"g11female_SFTY2","Grade 11 Female Safety 2"},
//				{"g11_TOT_SFTY2","Grade 11 Total Safety 2"},
//				{"g12male_SFTY2","Grade 12 Male Safety 2"},
//				{"g12female_SFTY2","Grade 12 Female Safety 2"},
//				{"g12_TOT_SFTY2","Grade 12 Total Safety 2"},
//				{"g11male_SCS","Grade 11 Male Ship’s Catering Services (NC I)"},
//				{"g11female_SCS","Grade 11 Female Ship’s Catering Services (NC I)"},
//				{"g11_TOT_SCS","Grade 11 Total Ship’s Catering Services (NC I)"},
//				{"g12male_SCS","Grade 12 Male Ship’s Catering Services (NC I)"},
//				{"g12female_SCS","Grade 12 Female Ship’s Catering Services (NC I)"},
//				{"g12_TOT_SCS","Grade 12 Total Ship’s Catering Services (NC I)"}
//				
//
//		};
//		
//		String[][] b=new String[][]{
//				
//				{"gmaleNW1","Total Male for Navigational Watch 1"},
//				{"gfemaleNW1","Total Female for Navigational Watch 1"},
//				{"TOT_NW1","Total Navigational Watch 1"},
//				{"gmale_TOT_NW2","Total Male for Navigational Watch 2"},
//				{"gfemale_TOT_NW2","Total Female for Navigational Watch 2"},
//				{"TOT_NW2","Total Navigational Watch 2"},
//				{"gmale_TOT_NW3","Total Male for Navigational Watch 3"},
//				{"gfemale_TOT_NW3","Total Female for Navigational Watch 3"},
//				{"TOT_NW3","Total Navigational Watch 3"},
//				{"gmale_TOT_EW1","Total Male for Engine Watch 1"},
//				{"gfemale_TOT_EW1","Total Female for Engine Watch 1"},
//				{"TOT_EW1","Total Engine Watch 1"},
//				{"gmale_TOT_EW2","Total Male for Engine Watch 2"},
//				{"gfemale_TOT_EW2","Total Female for Engine Watch 2"},
//				{"TOT_EW2","Total Engine Watch 2"},
//				{"gmale_TOT_SFTY1","Total Male for Safety 1"},
//				{"gfemale_TOT_SFTY1","Total Female for Safety 1"},
//				{"TOT_SFTY1","Total Safety 1"},
//				{"gmale_TOT_SFTY2","Total Male for Safety 2"},
//				{"gfemale_TOT_SFTY2","Total Female for Safety 2"},
//				{"TOT_SFTY2","Total Safety 2"},
//				{"gmale_TOT_SCS","Total Male for Ship’s Catering Services (NC I)"},
//				{"gfemale_TOT_SCS","Total Female for Ship’s Catering Services (NC I)"},
//				{"TOT_SCS","Total Ship’s Catering Services (NC I)"}
//
//		};
//		
//		ArrayList<Container> container=new ArrayList<Container>();
//		
//		for(int x=0,c=0,g=1;x<a.length;x++,g++)
//		{
//			if(g%7==0)
//			{
//				for(int z=c;c<z+3;c++)
//					container.add(new Container(b[c][0], b[c][1]));
//				
//				x--;
//				continue;
//			}
//			container.add(new Container(a[x][0], a[x][1]));
//		}
//		
//		for(Container c:container)
//		{
//			String f="{\"%s\",\"%s\"},";
//			System.out.println(String.format(f, c.left,c.right));
//		}
//		
//	}
}
