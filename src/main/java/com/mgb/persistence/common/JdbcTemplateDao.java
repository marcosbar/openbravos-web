package com.mgb.persistence.common;

import com.mgb.common.exceptions.NotFoundException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by mgb on 03/04/2016.
 */
public class JdbcTemplateDAO extends JdbcDaoSupport {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @SuppressWarnings("unchecked")
    public <T> T getOneResult(String sql, Object[] args, RowMapper<T> rowMapper) {

        List<T> result = (List)getJdbcTemplate().query(sql, args, new RowMapperResultSetExtractor(rowMapper));
        if(result.size()!=1){
            throw new NotFoundException();
        }
        return result.get(0);
    }

    protected DateTime getDateTime(Timestamp timestamp){
        if(timestamp!=null){
            return new DateTime(timestamp.getTime());
        }
        return null;
    }
}
