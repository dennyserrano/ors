
SELECT sph.sy_from, sph.school_id
-- Gastpe BOSY
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (582))),0) as g7male_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (582))),0) as g7female_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (582))),0) as g7tot_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (582))),0) as g8male_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (582))),0) as g8female_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (582))),0) as g8tot_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (582))),0) as g9male_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (582))),0) as g9female_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (582))),0) as g9tot_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (582))),0) as g10male_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (582))),0) as g10female_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (582))),0) as g10tot_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (582))),0) as g11male_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (582))),0) as g11female_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (582))),0) as g11tot_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (582))),0) as g12male_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (582))),0) as g12female_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (582))),0) as g12tot_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.pupil_data_indicator in (582))),0) as gtotmale_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.pupil_data_indicator in (582))),0) as gtotfemale_gastpebosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.pupil_data_indicator in (582))),0) as gtot_gastpebosy

-- Gastpe Slots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (594))),0) as g7_gastpeslots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (594))),0) as g8_gastpeslots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (594))),0) as g9_gastpeslots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (594))),0) as g10_gastpeslots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (594))),0) as g11_gastpeslots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (594))),0) as g12_gastpeslots
, IFNULL(SUM((SELECT SUM(IFNULL(en.level_total,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh.id AND en.grade_level_id in (232,105,106,107,108,497,595) AND en.pupil_data_indicator in (594))),0) as gtot_gastpeslots

-- Gastpe BOSY
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (577))),0) as g7male_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (577))),0) as g7female_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (577))),0) as g7tot_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (577))),0) as g8male_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (577))),0) as g8female_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (577))),0) as g8tot_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (577))),0) as g9male_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (577))),0) as g9female_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (577))),0) as g9tot_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (577))),0) as g10male_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (577))),0) as g10female_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (577))),0) as g10tot_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (577))),0) as g11male_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (577))),0) as g11female_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (577))),0) as g11tot_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (577))),0) as g12male_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (577))),0) as g12female_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (577))),0) as g12tot_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (577))),0) as gtotmale_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (577))),0) as gtotfemale_gastpeeosy
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (577))),0) as gtot_gastpeeosy

-- Gastpe Promotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (578))),0) as g7male_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (578))),0) as g7female_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (578))),0) as g7tot_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (578))),0) as g8male_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (578))),0) as g8female_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (578))),0) as g8tot_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (578))),0) as g9male_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (578))),0) as g9female_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (578))),0) as g9tot_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (578))),0) as g10male_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (578))),0) as g10female_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (578))),0) as g10tot_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (578))),0) as g11male_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (578))),0) as g11female_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (578))),0) as g11tot_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (578))),0) as g12male_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (578))),0) as g12female_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (578))),0) as g12tot_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (578))),0) as gtotmale_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (578))),0) as gtotfemale_gastpepromotees
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (578))),0) as gtot_gastpepromotees

-- Gastpe Dropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (579))),0) as g7male_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (579))),0) as g7female_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (579))),0) as g7tot_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (579))),0) as g8male_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (579))),0) as g8female_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (579))),0) as g8tot_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (579))),0) as g9male_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (579))),0) as g9female_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (579))),0) as g9tot_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (579))),0) as g10male_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (579))),0) as g10female_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (579))),0) as g10tot_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (579))),0) as g11male_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (579))),0) as g11female_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (579))),0) as g11tot_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (579))),0) as g12male_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (579))),0) as g12female_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (579))),0) as g12tot_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (579))),0) as gtotmale_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (579))),0) as gtotfemale_gastpedropouts
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (579))),0) as gtot_gastpedropouts

-- Gastpe Tranferred In
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (580))),0) as g7male_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (580))),0) as g7female_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (580))),0) as g7tot_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (580))),0) as g8male_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (580))),0) as g8female_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (580))),0) as g8tot_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (580))),0) as g9male_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (580))),0) as g9female_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (580))),0) as g9tot_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (580))),0) as g10male_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (580))),0) as g10female_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (580))),0) as g10tot_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (580))),0) as g11male_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (580))),0) as g11female_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (580))),0) as g11tot_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (580))),0) as g12male_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (580))),0) as g12female_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (580))),0) as g12tot_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (580))),0) as gtotmale_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (580))),0) as gtotfemale_gastpetransin
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (580))),0) as gtot_gastpetransin

-- Gastpe Tranferred out
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (581))),0) as g7male_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (581))),0) as g7female_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 105 AND en.pupil_data_indicator in (581))),0) as g7tot_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (581))),0) as g8male_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (581))),0) as g8female_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 106 AND en.pupil_data_indicator in (581))),0) as g8tot_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (581))),0) as g9male_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (581))),0) as g9female_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 107 AND en.pupil_data_indicator in (581))),0) as g9tot_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (581))),0) as g10male_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (581))),0) as g10female_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 108 AND en.pupil_data_indicator in (581))),0) as g10tot_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (581))),0) as g11male_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (581))),0) as g11female_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 497 AND en.pupil_data_indicator in (581))),0) as g11tot_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (581))),0) as g12male_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (581))),0) as g12female_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.grade_level_id = 595 AND en.pupil_data_indicator in (581))),0) as g12tot_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (581))),0) as gtotmale_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (581))),0) as gtotfemale_gastpetransout
, IFNULL(SUM((SELECT SUM(IFNULL(en.male,0)+IFNULL(en.female,0)) AS sum_en FROM ebeisdb.enrollment_pupil_summary en WHERE en.report_history_id = rh2.id AND en.pupil_data_indicator in (581))),0) as gtot_gastpetransout

-- Gastpe Personnel - Teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id in (562))),0) as gkmale_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id in (562))),0) as gkfemale_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id in (562))),0) as gktot_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id = if(sph.co_gen_class = 433,563,564))),0) as male_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id = if(sph.co_gen_class = 433,563,564))),0) as female_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id = if(sph.co_gen_class = 433,563,564))),0) as tot_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id in (565))),0) as gastpemale_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id in (565))),0) as gastpefemale_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560 AND ta.level_id in (565))),0) as gastpetot_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560)),0) as gtotmale_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560)),0) as gtotfemale_teachers
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 560)),0) as gtotal_teachers

-- Gastpe Personnel - Admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561 AND ta.level_id in (562))),0) as gkmale_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561 AND ta.level_id in (562))),0) as gkfemale_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561 AND ta.level_id in (562))),0) as gktot_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561 AND ta.level_id = if(sph.co_gen_class = 433,563,564))),0) as male_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561 AND ta.level_id = if(sph.co_gen_class = 433,563,564))),0) as female_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561 AND ta.level_id = if(sph.co_gen_class = 433,563,564))),0) as tot_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561)),0) as gtotmale_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561)),0) as gtotfemale_admin
, IFNULL(SUM((SELECT SUM(IFNULL(ta.male,0)+IFNULL(ta.female,0)) AS sum_ta FROM ebeisdb.teaching_assignment_summary ta WHERE ta.report_history_id = rh2.id AND ta.category_level_id = 199 and ta.subject_standard_id = 561)),0) as gtotal_admin

-- Academic Classrooms
, IFNULL(SUM((SELECT SUM(IFNULL(inv.quantity,0)) AS sum_inv FROM ebeisdb.inventory_summary inv WHERE inv.report_history_id = rh2.id AND inv.item_type_id = 3500 and inv.item_id = 350 AND inv.education_level_id in (435))),0) as gk_classroom
, IFNULL(SUM((SELECT SUM(IFNULL(inv.quantity,0)) AS sum_inv FROM ebeisdb.inventory_summary inv WHERE inv.report_history_id = rh2.id AND inv.item_type_id = 3500 and inv.item_id = 350 AND inv.education_level_id = sph.co_gen_class)),0) as classroom

-- School Seats
, IFNULL(SUM((SELECT SUM(IFNULL(inv.quantity,0)) AS sum_inv FROM ebeisdb.inventory_summary inv WHERE inv.report_history_id = rh2.id AND inv.item_type_id = 3700 and inv.item_id = 930 AND inv.education_level_id in (435))),0) as gk_seats
, IFNULL(SUM((SELECT SUM(IFNULL(inv.quantity,0)) AS sum_inv FROM ebeisdb.inventory_summary inv WHERE inv.report_history_id = rh2.id AND inv.item_type_id = 3700 and inv.item_id = 930 AND inv.education_level_id = sph.co_gen_class)),0) as seats

-- Senior High
, IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) AS sum_oyd FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id = rh.id AND oyd.category_id = 291 and oyd.item_id = 656)),0) as interested_SH
, IFNULL(SUM((SELECT SUM(IFNULL(oyd.figure,0)) AS sum_oyd FROM ebeisdb.other_yearly_data oyd WHERE oyd.report_history_id = rh.id AND oyd.category_id = 291 and oyd.item_id = 657)),0) as vacant_classroom

FROM ebeisdb.school_profile_history sph
   LEFT JOIN ebeisdb.ref_region rr ON (rr.id=sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   LEFT JOIN (ebeisdb.report_history rh2 
	      inner join ebeisdb.ref_report_history rrh2 on rh2.ref_report_history_id = rrh2.id
	      inner join ebeisdb.ref_reports rrs2 on rrs2.id  = rrh2.report_id
	      inner join ebeisdb.ref_report_generics rrg2 on rrg2.id = rrs2.ref_report_generics_id and rrg2.id=2
	 ) on rh2.school_id = sph.school_id and rh2.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   WHERE  sph.take_part_id IN (1,2,3) and sph.general_classification_id = 8 and sph.sy_from =2016
   GROUP BY rh.sy_from, sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC

INTO OUTFILE '/var/tmp/otherprivateschooldata.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
