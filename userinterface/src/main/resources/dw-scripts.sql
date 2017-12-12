-- DepEd Hive Database
CREATE DATABASE IF NOT EXISTS deped COMMENT 'The main database for the DepEd Data Warehouse.';

USE deped;

-- REFERENCES

-- Codes
CREATE EXTERNAL TABLE IF NOT EXISTS ref_code (
    id SMALLINT COMMENT 'LisRefCode Primary Key',
    code STRING COMMENT 'Reference Code',
    title STRING COMMENT 'Reference Code Title',
    description STRING COMMENT 'Reference Code Description',
    tmpid SMALLINT COMMENT 'Reference Code Temporary ID',
    org_id SMALLINT COMMENT 'Reference Code Organization ID'
)
STORED AS PARQUET
LOCATION '/user/deped/ref/codes';

-- Code Settings
CREATE EXTERNAL TABLE IF NOT EXISTS ref_code_setting (
    id SMALLINT,
    rank SMALLINT,
    description STRING,
    group_code STRING,
    member_code STRING,
    mother_code STRING,
    group_id SMALLINT,
    orggroupid SMALLINT,
    member_id SMALLINT,
    orgmmeberid SMALLINT,
    mother_id SMALLINT,
    tmpid SMALLINT,
    tmpgroupid SMALLINT,
    tmpmemberid SMALLINT,
    orgtmpid SMALLINT,
    sy_from SMALLINT,
    sy_to SMALLINT,
    timestamp BIGINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/code_settings';

-- Regions
CREATE EXTERNAL TABLE IF NOT EXISTS ref_region (
    id TINYINT,
    rank TINYINT,
    short_name STRING,
    region_name STRING,
    nscb_code STRING,
    old_regid STRING
)
STORED AS PARQUET
LOCATION '/user/deped/ref/regions';

-- Provinces
CREATE EXTERNAL TABLE IF NOT EXISTS ref_province (
    id TINYINT,
    province_name STRING,
    nscb_code STRING,
    region_id TINYINT,
    effective_sy SMALLINT,
    created_by INT,
    created_at BIGINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/provinces';

-- Municipalities
CREATE EXTERNAL TABLE IF NOT EXISTS ref_municipality (
    id INT,
    municipality_name STRING,
    nscb_code STRING,
    district_no TINYINT,
    province_id SMALLINT,
    income_class TINYINT,
    city_class SMALLINT,
    urp SMALLINT,
    legislative_id SMALLINT,
    legislative_orig_id SMALLINT,
    district_no_orig TINYINT,
    effective_sy SMALLINT,
    created_by INT,
    created_at BIGINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/municipalities';

-- Baranggay
CREATE EXTERNAL TABLE IF NOT EXISTS ref_baranggay (
    id INT,
    nscb_code STRING,
    brgy_name STRING,
    municipality_id INT,
    effective_sy SMALLINT,
    created_by INT,
    created_at BIGINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/baranggay';

-- Legislatives
CREATE EXTERNAL TABLE IF NOT EXISTS ref_legislatives (
    id SMALLINT,
    province_id SMALLINT,
    municipality_id INT,
    district_no TINYINT,
    date_established STRING,
    date_defunc STRING,
    district_label SMALLINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/legislatives';

-- Reports
CREATE EXTERNAL TABLE IF NOT EXISTS ref_reports (
    id SMALLINT,
    rank TINYINT,
    report_name STRING,
    report_description STRING,
    co_genclass_id SMALLINT,
    general_classification_id SMALLINT,
    school_subclassification_id SMALLINT,
    reports_generics_id SMALLINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/reports';

-- Report History
CREATE EXTERNAL TABLE IF NOT EXISTS ref_report_history (
    id INT,
    report_id SMALLINT,
    remarks STRING,
    report_date STRING,
    sy_from STRING,
    sy_to STRING,
    report_status SMALLINT,
    cutoff_date STRING,
    start_encoding_date STRING,
    school_deadline STRING,
    division_validation_deadline STRING,
    division_validation_extended STRING,
    created_by INT,
    created_at BIGINT,
    updated_by INT,
    updated_at BIGINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/report_history';

-- Office
CREATE EXTERNAL TABLE IF NOT EXISTS ref_office (
    id INT,
    office_type SMALLINT,
    office_name STRING,
    office_location_cd INT,
    office_address STRING,
    office_previous_address STRING,
    parent_office INT,
    contact_person INT,
    contact_person_position INT,
    telno STRING,
    faxno STRING,
    website STRING,
    office_description STRING,
    office_code STRING,
    region_id TINYINT,
    office_head_name STRING,
    office_head_position STRING,
    office_head_assistant STRING,
    office_head_assistant_position STRING,
    orig_ofc_cd STRING,
    date_created BIGINT,
    date_closed BIGINT,
    ebeis_point_person STRING,
    ebeis_point_person_email_address STRING,
    ebeis_point_person_contact_no STRING,
    interim_office_id INT,
    effective_sy SMALLINT,
    created_by INT,
    created_at BIGINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/offices';

-- Division Location
CREATE EXTERNAL TABLE IF NOT EXISTS ref_divlocation (
    id INT,
    sy_from SMALLINT,
    division_id INT,
    district_id INT,
    municipality_id INT,
    legislative_id SMALLINT,
    province_id SMALLINT
)
STORED AS PARQUET
LOCATION '/user/deped/ref/divlocation';

-- PERSONNEL Dimension
CREATE EXTERNAL TABLE IF NOT EXISTS personnel (
    id INT,
    office_id INT,
    creator_id SMALLINT,
    employment_type_id SMALLINT,
    school_employee_id STRING,
    last_name STRING,
    first_name STRING,
    middle_name STRING,
    employment_status_id SMALLINT,
    birth_date STRING,
    civil_status SMALLINT,
    gender SMALLINT,
    nationality SMALLINT,
    citizenship SMALLINT,
    religion SMALLINT,
    dialect_1 SMALLINT,
    dialect_2 SMALLINT,
    spouse_last_name STRING,
    spouse_first_name STRING,
    spouse_middle_name STRING,
    spouse_birth_date STRING,
    home_street_address STRING,
    home_municipality INT,
    home_baranggay INT,
    prc_lic_no STRING,
    civil_service_no STRING,
    gsis_no STRING,
    tin_no STRING,
    hmdf_no STRING,
    tel_no STRING,
    cel_no STRING,
    sss_no STRING,
    height FLOAT COMMENT 'Height in centimeters (sm)',
    weight FLOAT COMMENT 'Weight in kilograms (kg)',
    bloodtype SMALLINT,
    position_id SMALLINT,
    permanent_street_address STRING,
    permanent_home_municipality INT,
    permanent_home_baranggay INT,
    date_original_appointment STRING
)
STORED AS PARQUET
LOCATION '/user/deped/ebeis/personnel';

-- SCHOOL FACT Scripts
CREATE EXTERNAL TABLE IF NOT EXISTS school_fact (
    id INT,
    sy_from SMALLINT,
    school_id INT,
    old_school_id INT,
    user_id INT,
    school_name STRING,
    short_name STRING,
    previous_name STRING,
    school_head INT,
    school_head_position INT,
    registrar INT,
    registrar_position INT,
    street_address STRING,
    zip_cd STRING,
    municipality INT,
    baranggay INT,
    division INT,
    district INT,
    region INT,
    province INT,
    telephone_no STRING,
    fax_no STRING,
    mobile_no STRING,
    school_contact INT,
    email_address STRING,
    web_address STRING,
    mother_school_id INT,
    date_established STRING,
    general_classification_id SMALLINT,
    school_subclassification_id SMALLINT,
    curricular_class_id SMALLINT,
    curricular_subclass_id SMALLINT,
    secondary_co_subclass_id SMALLINT,
    class_organization_id SMALLINT,
    site_ownership_id SMALLINT,
    proof_of_ownership_id SMALLINT,
    ownership_issue_id SMALLINT,
    land_area FLOAT,
    topography_id SMALLINT,
    funding_type SMALLINT,
    secondary_school_id INT,
    school_head_name STRING,
    school_head_position_name STRING,
    registrar_name STRING,
    school_head_name_eosy STRING,
    school_head_position_name_eosy STRING,
    school_type_id SMALLINT,
    accreditation_number INT,
    co_gen_class SMALLINT,
    date_closed STRING,
    legislative SMALLINT,
    elementary_class_id INT,
    cointegrated_id INT,
    bosy_validated_by SMALLINT,
    to_dist_kms DOUBLE,
    to_dist_means STRING,
    to_dist_cost DOUBLE,
    to_dist_min INT,
    to_div_kms DOUBLE,
    to_div_means STRING,
    to_div_cost DOUBLE,
    to_div_min INT,
    no_isp TINYINT,
    invalid SMALLINT,
    created_at BIGINT,
    created_by INT,
    updated_at BIGINT,
    updated_by INT,
    permit_no STRING,
    permit_no_kinder STRING,
    permit_no_secondary STRING,
    recognition_no STRING,
    recognition_no_kinder STRING,
    recognition_no_secondary STRING,
    pmrtappdt_submttd STRING,
    prmtappdt_submttd_kidner STRING,
    prmtpapdt_submttd_secondary STRING,
    enrol_id SMALLINT,
    program_id SMALLINT,
    bosy_validated_dt BIGINT,
    eosy_validated_by INT,
    esoy_validated_dt BIGINT,
    close_reason STRING,
    reopen_date STRING,
    sph_status TINYINT,
    nearest_ges STRING,
    to_nearest_ges_kms DOUBLE,
    to_nearest_ges_means STRING,
    to_nearest_ges_cost DOUBLE,
    to_nearset_ges_min INT,
    nearest_gss STRING,
    to_nearest_gss_kms DOUBLE,
    to_nearest_gss_means STRING,
    to_nearest_gss_cost DOUBLE,
    to_nearest_gss_min INT,
    nearest_pes STRING,
    to_nearest_pes_kms DOUBLE,
    to_nearest_pes_means STRING,
    to_nearest_pes_cost DOUBLE,
    to_nearset_pes_min INT,
    nearest_pss STRING,
    to_nearest_pss_kms DOUBLE,
    to_nearest_pss_means STRING,
    to_nearest_pss_cost DOUBLE,
    to_nearest_pss_min INT,
    night_school TINYINT,
    registrar_position_name STRING,
    take_part_id TINYINT,
    beis_school_id INT,
    attached_totertiary TINYINT,
    date_of_operation STRING
)
STORED AS PARQUET
LOCATION '/user/deped/ebeis/school_fact';
