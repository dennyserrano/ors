
CREATE TABLE `dataset_correlation_group_dtl` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataset_correlation_group_id` int(11) NOT NULL,
  `dataset_correlation_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
