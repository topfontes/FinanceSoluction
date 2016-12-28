package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class For_fornecedorDAO extends ObjectDAOCluster {

    public For_fornecedorDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.for_fornecedor  ( for_tx_endereco, for_tx_home_page, for_tx_contato, for_tx_cpf_cnpj, for_tx_email, for_tx_rg_inscricao, for_tx_cep, for_tx_cidade, for_tx_estado, for_tx_bairro, for_tx_nome, for_tx_status, loj_nr_id, for_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_tx_endereco());
            pStmt.setObject(2, for_fornecedorT.getFor_tx_home_page());
            pStmt.setObject(3, for_fornecedorT.getFor_tx_contato());
            pStmt.setObject(4, for_fornecedorT.getFor_tx_cpf_cnpj());
            pStmt.setObject(5, for_fornecedorT.getFor_tx_email());
            pStmt.setObject(6, for_fornecedorT.getFor_tx_rg_inscricao());
            pStmt.setObject(7, for_fornecedorT.getFor_tx_cep());
            pStmt.setObject(8, for_fornecedorT.getFor_tx_cidade());
            pStmt.setObject(9, for_fornecedorT.getFor_tx_estado());
            pStmt.setObject(10, for_fornecedorT.getFor_tx_bairro());
            pStmt.setObject(11, for_fornecedorT.getFor_tx_nome());
            pStmt.setObject(12, for_fornecedorT.getFor_tx_status());
            pStmt.setObject(13, for_fornecedorT.getLoj_nr_id());
            pStmt.setObject(14, for_fornecedorT.getFor_nr_id());
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

    public void update(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.for_fornecedor set  for_tx_endereco=?, for_tx_home_page=?, for_tx_contato=?, for_tx_cpf_cnpj=?, for_tx_email=?, for_tx_rg_inscricao=?, for_tx_cep=?, for_tx_cidade=?, for_tx_estado=?, for_tx_bairro=?, for_tx_nome=?, for_tx_status=?, loj_nr_id=?  where  for_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_tx_endereco());
            pStmt.setObject(2, for_fornecedorT.getFor_tx_home_page());
            pStmt.setObject(3, for_fornecedorT.getFor_tx_contato());
            pStmt.setObject(4, for_fornecedorT.getFor_tx_cpf_cnpj());
            pStmt.setObject(5, for_fornecedorT.getFor_tx_email());
            pStmt.setObject(6, for_fornecedorT.getFor_tx_rg_inscricao());
            pStmt.setObject(7, for_fornecedorT.getFor_tx_cep());
            pStmt.setObject(8, for_fornecedorT.getFor_tx_cidade());
            pStmt.setObject(9, for_fornecedorT.getFor_tx_estado());
            pStmt.setObject(10, for_fornecedorT.getFor_tx_bairro());
            pStmt.setObject(11, for_fornecedorT.getFor_tx_nome());
            pStmt.setObject(12, for_fornecedorT.getFor_tx_status());
            pStmt.setObject(13, for_fornecedorT.getLoj_nr_id());
            pStmt.setObject(14, for_fornecedorT.getFor_nr_id());
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

    public void delete(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.for_fornecedor where  for_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_nr_id());
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

    private List<For_fornecedorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<For_fornecedorT> objs = new Vector();
        while (rs.next()) {
            For_fornecedorT for_fornecedorT = new For_fornecedorT();
            for_fornecedorT.setFor_nr_id(rs.getInt("for_nr_id"));
            for_fornecedorT.setFor_tx_endereco(rs.getString("for_tx_endereco"));
            for_fornecedorT.setFor_tx_home_page(rs.getString("for_tx_home_page"));
            for_fornecedorT.setFor_tx_contato(rs.getString("for_tx_contato"));
            for_fornecedorT.setFor_tx_cpf_cnpj(rs.getString("for_tx_cpf_cnpj"));
            for_fornecedorT.setFor_tx_email(rs.getString("for_tx_email"));
            for_fornecedorT.setFor_tx_rg_inscricao(rs.getString("for_tx_rg_inscricao"));
            for_fornecedorT.setFor_tx_cep(rs.getInt("for_tx_cep"));
            for_fornecedorT.setFor_tx_cidade(rs.getString("for_tx_cidade"));
            for_fornecedorT.setFor_tx_estado(rs.getString("for_tx_estado"));
            for_fornecedorT.setFor_tx_bairro(rs.getString("for_tx_bairro"));
            for_fornecedorT.setFor_tx_nome(rs.getString("for_tx_nome"));
            for_fornecedorT.setFor_tx_status(rs.getString("for_tx_status"));
            for_fornecedorT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(for_fornecedorT);
        }
        return objs;
    }

    public List<For_fornecedorT> getAll(int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where loj_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
            rs = pStmt.executeQuery();
            List<For_fornecedorT> list = resultSetToObjectTransfer(rs);
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

    public List<For_fornecedorT> getByPK(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  for_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_nr_id());
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

    public List<For_fornecedorT> getByFor_nr_id(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  for_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_nr_id());
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

    public List<For_fornecedorT> getByFor_tx_endereco(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_endereco) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_endereco() + '%');
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

    public List<For_fornecedorT> getByFor_tx_home_page(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_home_page) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_home_page() + '%');
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

    public List<For_fornecedorT> getByFor_tx_contato(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_contato) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_contato() + '%');
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

    public List<For_fornecedorT> getByFor_tx_cpf_cnpj(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_cpf_cnpj) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_cpf_cnpj() + '%');
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

    public List<For_fornecedorT> getByFor_tx_email(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_email) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_email() + '%');
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

    public List<For_fornecedorT> getByFor_tx_rg_inscricao(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_rg_inscricao) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_rg_inscricao() + '%');
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

    public List<For_fornecedorT> getByFor_tx_cep(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  for_tx_cep = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_tx_cep());
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

    public List<For_fornecedorT> getByFor_tx_cidade(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_cidade) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_cidade() + '%');
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

    public List<For_fornecedorT> getByFor_tx_estado(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_estado) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_estado() + '%');
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

    public List<For_fornecedorT> getByFor_tx_bairro(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_bairro) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_bairro() + '%');
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

    public List<For_fornecedorT> getByFor_tx_nome(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_nome() + '%');
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

    public List<For_fornecedorT> getByFor_tx_status(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  Upper(for_tx_status) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_status() + '%');
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

    public List<For_fornecedorT> getByLoj_nr_id(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getLoj_nr_id());
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

    /**
     * Metodos FK
     */
    public List<For_fornecedorT> getByLoj_loja(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.for_fornecedor where loj_loja.loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, for_fornecedorT.getLoj_nr_id());
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
