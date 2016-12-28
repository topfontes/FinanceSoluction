package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Car_cartaoDAO extends ObjectDAOCluster {

    public Car_cartaoDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.car_cartao  ( car_per_taxa, car_tx_status, car_tx_nome, loj_nr_id, car_nr_id) values ( ?, ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getCar_per_taxa());
            pStmt.setObject(2, car_cartaoT.getCar_tx_status());
            pStmt.setObject(3, car_cartaoT.getCar_tx_nome());
            pStmt.setObject(4, car_cartaoT.getLoj_nr_id());
            pStmt.setObject(5, car_cartaoT.getCar_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.car_cartao set  car_per_taxa=?, car_tx_status=?, car_tx_nome=?, loj_nr_id=?  where  car_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getCar_per_taxa());
            pStmt.setObject(2, car_cartaoT.getCar_tx_status());
            pStmt.setObject(3, car_cartaoT.getCar_tx_nome());
            pStmt.setObject(4, car_cartaoT.getLoj_nr_id());
            pStmt.setObject(5, car_cartaoT.getCar_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.car_cartao where  car_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getCar_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Car_cartaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Car_cartaoT> objs = new Vector();
        while (rs.next()) {
            Car_cartaoT car_cartaoT = new Car_cartaoT();
            car_cartaoT.setCar_nr_id(rs.getInt("car_nr_id"));
            car_cartaoT.setCar_per_taxa(rs.getDouble("car_per_taxa"));
            car_cartaoT.setCar_tx_status(rs.getString("car_tx_status"));
            car_cartaoT.setCar_tx_nome(rs.getString("car_tx_nome"));
            car_cartaoT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(car_cartaoT);
        }
        return objs;
    }

    public List<Car_cartaoT> getAll(int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where loj_nr_id = ?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
            rs = pStmt.executeQuery();
            List<Car_cartaoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> getByPK(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where  car_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getCar_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> getByCar_nr_id(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where  car_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getCar_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> getByCar_per_taxa(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where  car_per_taxa = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getCar_per_taxa());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> getByCar_tx_status(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where  Upper(car_tx_status) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + car_cartaoT.getCar_tx_status() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> getByCar_tx_nome(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where  Upper(car_tx_nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + car_cartaoT.getCar_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> getByLoj_nr_id(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.car_cartao where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, car_cartaoT.getLoj_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

}
