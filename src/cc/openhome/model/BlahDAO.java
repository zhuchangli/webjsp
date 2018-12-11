package cc.openhome.model;/*
 * created by on 12/10/18
 */

import java.util.List;

public interface BlahDAO {
    List<Blah> getBlahs(Blah blah);
    void addBlah(Blah blah);
    void deleteBlah(Blah blah);
}
