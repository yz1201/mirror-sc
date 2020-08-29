package cn.dbdj1201.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @author yz1201
 * @date 2020-08-28 22:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark implements Serializable {

    private List<Bookmark> children;

    private Long date_added;

    private Long date_modified;

    private String guid;

    private Integer id;

    private String name;

    private String type;

    private String url;

}
