SELECT 

DE.id as element_id,
DE.name as element_name ,
DH.id as head_id,
DH.name as head_name

FROM dataset_element DE
INNER JOIN dataset_head DH ON DE.dataset_head_id=DH.id
WHERE DE.name in ('building_classification','building_structure_type','building_condition','fund_source','specific_fund_source','type_name')