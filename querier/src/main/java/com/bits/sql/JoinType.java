package com.bits.sql;

import static com.bits.sql.Keywords.JOIN;

/**
 * Created by PSY on 2014/09/03.
 */
public enum JoinType implements SqlExpression {

    LEFT_JOIN {
        public String get() { return " LEFT" + JOIN.get(); }
    },

    RIGHT_JOIN {
        public String get() { return " RIGHT" + JOIN.get(); }
    },

    INNER_JOIN {
        public String get() { return " INNER" + JOIN.get(); }
    },

    STRAIGHT_JOIN {
        public String get() { return " STRAIGHT" + JOIN.get(); }
    },

    CROSS_JOIN {
        public String get() { return " CROSS" + JOIN.get(); }
    }

}
