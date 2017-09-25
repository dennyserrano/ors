package ph.gov.deped;

import java.util.ArrayList;


public class ParseTest {
	public static void main(String[] args) {
	
	String[][] a=new String[][]{
			{"g11maleNW1","Grade 11 Male Navigational Watch 1"},
			{"g11femaleNW1","Grade 11 Female Navigational Watch 1"},
			{"g11_TOTNW1","Grade 11 Total Navigational Watch 1"},
			{"g12maleNW1","Grade 12 Male Navigational Watch 1"},
			{"g12femaleNW1","Grade 12 Female Navigational Watch 1"},
			{"g12_TOTNW1","Grade 12 Total Navigational Watch 1"},
			{"gmaleNW1","Total Male for Navigational Watch 1"},
			{"gfemaleNW1","Total Female for Navigational Watch 1"},
			{"TOT_NW1","Total Navigational Watch 1"},
			{"g11male_NW2","Grade 11 Male Navigational Watch 2"},
			{"g11female_NW2","Grade 11 Female Navigational Watch 2"},
			{"g11_TOT_NW2","Grade 11 Total Navigational Watch 2"},
			{"g12male_NW2","Grade 12 Male Navigational Watch 2"},
			{"g12female_NW2","Grade 12 Female Navigational Watch 2"},
			{"g12_TOT_NW2","Grade 12 Total Navigational Watch 2"},
			{"gmale_TOT_NW2","Total Male for Navigational Watch 2"},
			{"gfemale_TOT_NW2","Total Female for Navigational Watch 2"},
			{"TOT_NW2","Total Navigational Watch 2"},
			{"g11male_NW3","Grade 11 Male Navigational Watch 3"},
			{"g11female_NW3","Grade 11 Female Navigational Watch 3"},
			{"g11_TOT_NW3","Grade 11 Total Navigational Watch 3"},
			{"g12male_NW3","Grade 12 Male Navigational Watch 3"},
			{"g12female_NW3","Grade 12 Female Navigational Watch 3"},
			{"g12_TOT_NW3","Grade 12 Total Navigational Watch 3"},
			{"gmale_TOT_NW3","Total Male for Navigational Watch 3"},
			{"gfemale_TOT_NW3","Total Female for Navigational Watch 3"},
			{"TOT_NW3","Total Navigational Watch 3"},
			{"g11male_EW1","Grade 11 Male Engine Watch 1"},
			{"g11female_EW1","Grade 11 Female Engine Watch 1"},
			{"g11_TOT_EW1","Grade 11 Total Engine Watch 1"},
			{"g12male_EW1","Grade 12 Male Engine Watch 1"},
			{"g12female_EW1","Grade 12 Female Engine Watch 1"},
			{"g12_TOT_EW1","Grade 12 Total Engine Watch 1"},
			{"gmale_TOT_EW1","Total Male for Engine Watch 1"},
			{"gfemale_TOT_EW1","Total Female for Engine Watch 1"},
			{"TOT_EW1","Total Engine Watch 1"},
			{"g11male_EW2","Grade 11 Male Engine Watch 2"},
			{"g11female_EW2","Grade 11 Female Engine Watch 2"},
			{"g11_TOT_EW2","Grade 11 Total Engine Watch 2"},
			{"g12male_EW2","Grade 12 Male Engine Watch 2"},
			{"g12female_EW2","Grade 12 Female Engine Watch 2"},
			{"g12_TOT_EW2","Grade 12 Total Engine Watch 2"},
			{"gmale_TOT_EW2","Total Male for Engine Watch 2"},
			{"gfemale_TOT_EW2","Total Female for Engine Watch 2"},
			{"TOT_EW2","Total Engine Watch 2"},
			{"g11male_SFTY1","Grade 11 Male Safety 1"},
			{"g11female_SFTY1","Grade 11 Female Safety 1"},
			{"g11_TOT_SFTY1","Grade 11 Total Safety 1"},
			{"g12male_SFTY1","Grade 12 Male Safety 1"},
			{"g12female_SFTY1","Grade 12 Female Safety 1"},
			{"g12_TOT_SFTY1","Grade 12 Total Safety 1"},
			{"gmale_TOT_SFTY1","Total Male for Safety 1"},
			{"gfemale_TOT_SFTY1","Total Female for Safety 1"},
			{"TOT_SFTY1","Total Safety 1"},
			{"g11male_SFTY2","Grade 11 Male Safety 2"},
			{"g11female_SFTY2","Grade 11 Female Safety 2"},
			{"g11_TOT_SFTY2","Grade 11 Total Safety 2"},
			{"g12male_SFTY2","Grade 12 Male Safety 2"},
			{"g12female_SFTY2","Grade 12 Female Safety 2"},
			{"g12_TOT_SFTY2","Grade 12 Total Safety 2"},
			{"gmale_TOT_SFTY2","Total Male for Safety 2"},
			{"gfemale_TOT_SFTY2","Total Female for Safety 2"},
			{"TOT_SFTY2","Total Safety 2"},
			{"g11male_SCS","Grade 11 Male Ship’s Catering Services (NC I)"},
			{"g11female_SCS","Grade 11 Female Ship’s Catering Services (NC I)"},
			{"g11_TOT_SCS","Grade 11 Total Ship’s Catering Services (NC I)"},
			{"g12male_SCS","Grade 12 Male Ship’s Catering Services (NC I)"},
			{"g12female_SCS","Grade 12 Female Ship’s Catering Services (NC I)"},
			{"g12_TOT_SCS","Grade 12 Total Ship’s Catering Services (NC I)"},
			{"gmale_TOT_SCS","Total Male for Ship’s Catering Services (NC I)"},
			{"gfemale_TOT_SCS","Total Female for Ship’s Catering Services (NC I)"},
			{"TOT_SCS","Total Ship’s Catering Services (NC I)"}
			
	};
	String strRef="INSERT INTO orsdb.column_metadata(table_id,column_name,data_type,nullable,min,max,date_created,created_by,date_updated,updated_by,primary_key) \n"
			+ "VALUES(@table_id,'%s','smallint',0,0,11,curdate(),'SYSTEM',curdate(),'SYSTEM',1); \n \n"
			+ "INSERT INTO orsdb.dataset_element(column_id,alias,function,date_created,created_by,date_updated,updated_by,name,meaning,description,dataset_head_id,visible) \n"
			+ "VALUES(LAST_INSERT_ID(),NULL,NULL,curdate(),'SYSTEM',curdate(),'SYSTEM','%s','%s','%s',@dataset_head_id,1); \n \n";
	
	
	for(int x=0;x<a.length;x++)
	{
		String c1=a[x][0];
		String c2=a[x][1];
		System.out.println(String.format(strRef, c1,c1,c2,c2));
	}
	
}

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
