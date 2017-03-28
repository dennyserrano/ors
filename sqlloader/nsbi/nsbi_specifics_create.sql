CREATE TABLE orsdb.`nsbi_specifics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sy_from` smallint(5) DEFAULT 0,
  `school_id` int(11) NOT NULL,
  `bldg_struct` varchar(9) NOT NULL,
  `bldg_struct_num` tinyint(3) NOT NULL,
  `bldg_struct_type_id` int(11) NOT NULL,
  `bldg_cond_id` int(11) NOT NULL,
  `bldg_class_id` int(11) NOT NULL,
  `storeys` tinyint(3) DEFAULT '0',
  `fund_src_id` int(11) NOT NULL,
  `specific_fund_src_id` int(11) NOT NULL,
  `bldg_dimnsn_len` float DEFAULT '0',
  `bldg_dimnsn_wdth` float DEFAULT '0',
  `rm_number` tinyint(3) DEFAULT '0',
  `class_cond_id` int(11) NOT NULL,
  `repair_5yrs` tinyint(3) DEFAULT '0',
  `rm_dimnsn_len` float DEFAULT '0',
  `rm_dimnsn_wdth` float DEFAULT '0',
  `concurrent_usage` tinyint(3) DEFAULT '0',
  `kinder_class` tinyint(3) DEFAULT '0',
  `g1_class` tinyint(3) DEFAULT '0',
  `g2_class` tinyint(3) DEFAULT '0',
  `g3_class` tinyint(3) DEFAULT '0',
  `g4_class` tinyint(3) DEFAULT '0',
  `g5_class` tinyint(3) DEFAULT '0',
  `g6_class` tinyint(3) DEFAULT '0',
  `g7_class` tinyint(3) DEFAULT '0',
  `g8_class` tinyint(3) DEFAULT '0',
  `g9_class` tinyint(3) DEFAULT '0',
  `g10_class` tinyint(3) DEFAULT '0',
  `g11_class` tinyint(3) DEFAULT '0',
  `g12_class` tinyint(3) DEFAULT '0',
  `sped_class` tinyint(3) DEFAULT '0',
  `als_rm` tinyint(3) DEFAULT '0',
  `comp_rm` tinyint(3) DEFAULT '0',
  `indus_arts_rm` tinyint(3) DEFAULT '0',
  `home_econ_rm` tinyint(3) DEFAULT '0',
  `sci_lab` tinyint(3) DEFAULT '0',
  `speech_lab` tinyint(3) DEFAULT '0',
  `research_lab` tinyint(3) DEFAULT '0',
  `inst_aud_visual` tinyint(3) DEFAULT '0',
  `inst_not_used` tinyint(3) DEFAULT '0',
  `lib_res_cntr` tinyint(3) DEFAULT '0',
  `canteen` tinyint(3) DEFAULT '0',
  `clinic` tinyint(3) DEFAULT '0',
  `conf_room` tinyint(3) DEFAULT '0',
  `offices` tinyint(3) DEFAULT '0',
  `faclty_rm` tinyint(3) DEFAULT '0',
  `museum` tinyint(3) DEFAULT '0',
  `supply_rm` tinyint(3) DEFAULT '0',
  `datafle_rm` tinyint(3) DEFAULT '0',
  `stud_curr_cntr` tinyint(3) DEFAULT '0',
  `youth_dev` tinyint(3) DEFAULT '0',
  `nonInst_aud_vis` tinyint(3) DEFAULT '0',
  `nonInst_notUsed` tinyint(3) DEFAULT '0',
  `others` tinyint(3) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
