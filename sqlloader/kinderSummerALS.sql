insert into orsdb.enrollment_kinder_als(school_year,school_id,gkmale_age4Below,gkfemale_age4Below,gktot_age4Below,gkmale_age5,
gkfemale_age5,gktot_age5,gkmale_age6,gkfemale_age6,gktot_age6,gkmale_age7,gkfemale_age7,gktot_age7,gkmale_age8,gkfemale_age8,
gktot_age8,gkmale_age9,gkfemale_age9,gktot_age9,gkmale_age10,gkfemale_age10,gktot_age10,gkmale_age11,gkfemale_age11,gktot_age11,
gkmale_age12Above,gkfemale_age12Above,gktot_age12Above,gkmale_tot,gkfemale_tot,gktot_total,alsmale_age11Below,alsfemale_age11Below,
alstot_age11Below,alsmale_age12,alsfemale_age12,alstot_age12,alsmale_age13,alsfemale_age13,alstot_age13,alsmale_age14,
alsfemale_age14,alstot_age14,alsmale_age15,alsfemale_age15,alstot_age15,alsmale_age16to20,alsfemale_age16to20,alstot_age116to20,
alsmale_age21to25,alsfemale_age21to25,alstot_age21to25,alsmale_age26to30,alsfemale_age26to30,alstot_age26to30,alsmale_age31Above,
alsfemale_age31Above,alstot_age31Above,alsmale_age15Below,alsfemale_age15Below,alstot_age15Below,alsmale_age16,alsfemale_age16,
alstot_age16,alsmale_age17,alsfemale_age17,alstot_age17,alsmale_age18,alsfemale_age18,alstot_age18,alsmale_age19,alsfemale_age19,
alstot_age19,alsmale_age20,alsfemale_age20,alstot_age20,alsmale_age21,alsfemale_age21,alstot_age21,alsmale_age22,alsfemale_age22,
alstot_age22,alsmale_age23,alsfemale_age23,alstot_age23,alsmale_age24,alsfemale_age24,alstot_age24,alsmale_age25,alsfemale_age25,
alstot_age25,alsmale_age26Above,alsfemale_age26Above,alstot_age26Above,alsmale_tot,alsfemale_tot,alstot_total)

SELECT sph.sy_from, sph.school_id
-- Kinder Summer Program
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 225)),0) as gkmale_age4Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 225)),0) as gkfemale_age4Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 225)),0) as gktot_age4Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 226)),0) as gkmale_age5
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 226)),0) as gkfemale_age5
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 226)),0) as gktot_age5
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 227)),0) as gkmale_age6
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 227)),0) as gkfemale_age6
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 227)),0) as gktot_age6
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 228)),0) as gkmale_age7
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 228)),0) as gkfemale_age7
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 228)),0) as gktot_age7
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 229)),0) as gkmale_age8
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 229)),0) as gkfemale_age8
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 229)),0) as gktot_age8
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 230)),0) as gkmale_age9
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 230)),0) as gkfemale_age9
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 230)),0) as gktot_age9
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 231)),0) as gkmale_age10
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 231)),0) as gkfemale_age10
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 231)),0) as gktot_age10
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 232)),0) as gkmale_age11
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 232)),0) as gkfemale_age11
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 232)),0) as gktot_age11
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 385)),0) as gkmale_age12Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 385)),0) as gkfemale_age12Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405 and sp.age_category_id = 385)),0) as gktot_age12Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405)),0) as gkmale_tot
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405)),0) as gkfemale_tot
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 496 AND sp.grade_level_id = 405)),0) as gktot_total

-- ALS Learners - Elementary
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 499)),0) as alsmale_age11Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 499)),0) as alsfemale_age11Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 499)),0) as alstot_age11Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 505)),0) as alsmale_age12
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 505)),0) as alsfemale_age12
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 505)),0) as alstot_age12
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 506)),0) as alsmale_age13
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 506)),0) as alsfemale_age13
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 506)),0) as alstot_age13
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 508)),0) as alsmale_age14
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 508)),0) as alsfemale_age14
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 508)),0) as alstot_age14
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 509)),0) as alsmale_age15
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 509)),0) as alsfemale_age15
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 509)),0) as alstot_age15
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 512)),0) as alsmale_age16to20
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 512)),0) as alsfemale_age16to20
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 512)),0) as alstot_age116to20
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 513)),0) as alsmale_age21to25
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 513)),0) as alsfemale_age21to25
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 513)),0) as alstot_age21to25
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 514)),0) as alsmale_age26to30
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 514)),0) as alsfemale_age26to30
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 514)),0) as alstot_age26to30
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 536)),0) as alsmale_age31Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 536)),0) as alsfemale_age31Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 536)),0) as alstot_age31Above

-- ALS Learners - Secondary
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 535)),0) as alsmale_age15Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 535)),0) as alsfemale_age15Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 535)),0) as alstot_age15Below
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 548)),0) as alsmale_age16
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 548)),0) as alsfemale_age16
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 548)),0) as alstot_age16
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 549)),0) as alsmale_age17
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 549)),0) as alsfemale_age17
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 549)),0) as alstot_age17
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 550)),0) as alsmale_age18
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 550)),0) as alsfemale_age18
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 550)),0) as alstot_age18
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 551)),0) as alsmale_age19
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 551)),0) as alsfemale_age19
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 551)),0) as alstot_age19
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 553)),0) as alsmale_age20
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 553)),0) as alsfemale_age20
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 553)),0) as alstot_age20
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 554)),0) as alsmale_age21
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 554)),0) as alsfemale_age21
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 554)),0) as alstot_age21
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 555)),0) as alsmale_age22
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 555)),0) as alsfemale_age22
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 555)),0) as alstot_age22
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 556)),0) as alsmale_age23
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 556)),0) as alsfemale_age23
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 556)),0) as alstot_age23
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 557)),0) as alsmale_age24
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 557)),0) as alsfemale_age24
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 557)),0) as alstot_age24
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 558)),0) as alsmale_age25
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 558)),0) as alsfemale_age25
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 558)),0) as alstot_age25
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 559)),0) as alsmale_age26Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 559)),0) as alsfemale_age26Above
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98 and sp.age_category_id = 559)),0) as alstot_age26Above

-- ALS Learners Total
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98)),0) as alsmale_tot
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98)),0) as alsfemale_tot
, IFNULL(SUM((SELECT SUM(IFNULL(sp.enroll_male,0)+IFNULL(sp.enroll_female,0)) FROM ebeisdb.summer_program_summary sp WHERE sp.report_history_id = rh.id AND sp.category_id = 498 AND sp.grade_level_id = 98)),0) as alstot_total

FROM ebeisdb.school_profile_history sph
   LEFT JOIN ref_region rr on (rr.id = sph.region_id)
   LEFT JOIN (ebeisdb.report_history rh 
	      inner join ebeisdb.ref_report_history rrh on rh.ref_report_history_id = rrh.id
	      inner join ebeisdb.ref_reports rrs on rrs.id  = rrh.report_id
	      inner join ebeisdb.ref_report_generics rrg on rrg.id = rrs.ref_report_generics_id and rrg.id=1
	 ) on rh.school_id = sph.school_id and rh.sy_from= sph.sy_from and rh.report_status > 300 -- cast( sph.sy_from as unsigned)
   WHERE  sph.take_part_id IN (1,2,3) and sph.general_classification_id = 7 and sph.sy_from between 2016 and 2016 
   GROUP BY rh.sy_from, sph.SCHOOL_ID 
   ORDER BY sph.SY_FROM, rr.RANK ASC, sph.SCHOOL_ID ASC;

commit;
