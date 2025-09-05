package DAO;

import java.util.List;

    public interface GenericDAO {
        public List<Object> getAll();

        public Object getById(int id);

        public Boolean add(Object object);

        public boolean update(Object object);

        public void delete(int id);
    }
}
