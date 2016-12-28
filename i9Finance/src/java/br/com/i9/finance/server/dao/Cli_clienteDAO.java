package br.com.i9.finance.server.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.jdragon.dao.cluster.*;
import br.com.i9.finance.client.i9finance.easyfin.transfer.*;

public class Cli_clienteDAO extends ObjectDAOCluster {

    public Cli_clienteDAO(DAOFactoryCluster dao) throws Exception {
        setdAOFactoryCluster(dao);
    }

    public void insert(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyfin.cli_cliente  ( cli_tx_nome, cli_tx_endereco, cli_tx_bairro, cli_tx_rg_inscricao, cli_tx_cidade, cli_tx_estado, cli_tx_cep, cli_tx_cpf_cnpj, cli_tx_email, cli_tx_home_page, cli_tx_contato, cli_tx_status, loj_nr_id, cli_nr_id) values ( ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
            pStmt.setObject(2, cli_clienteT.getCli_tx_endereco());
            pStmt.setObject(3, cli_clienteT.getCli_tx_bairro());
            pStmt.setObject(4, cli_clienteT.getCli_tx_rg_inscricao());
            pStmt.setObject(5, cli_clienteT.getCli_tx_cidade());
            pStmt.setObject(6, cli_clienteT.getCli_tx_estado());
            pStmt.setObject(7, cli_clienteT.getCli_tx_cep());
            pStmt.setObject(8, cli_clienteT.getCli_tx_cpf_cnpj());
            pStmt.setObject(9, cli_clienteT.getCli_tx_email());
            pStmt.setObject(10, cli_clienteT.getCli_tx_home_page());
            pStmt.setObject(11, cli_clienteT.getCli_tx_contato());
            pStmt.setObject(12, cli_clienteT.getCli_tx_status());
            pStmt.setObject(13, cli_clienteT.getLoj_nr_id());
            pStmt.setObject(14, cli_clienteT.getCli_nr_id());
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

    public void update(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyfin.cli_cliente set  cli_tx_nome=?, cli_tx_endereco=?, cli_tx_bairro=?, cli_tx_rg_inscricao=?, cli_tx_cidade=?, cli_tx_estado=?, cli_tx_cep=?, cli_tx_cpf_cnpj=?, cli_tx_email=?, cli_tx_home_page=?, cli_tx_contato=?, cli_tx_status=?, loj_nr_id=?  where  cli_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
            pStmt.setObject(2, cli_clienteT.getCli_tx_endereco());
            pStmt.setObject(3, cli_clienteT.getCli_tx_bairro());
            pStmt.setObject(4, cli_clienteT.getCli_tx_rg_inscricao());
            pStmt.setObject(5, cli_clienteT.getCli_tx_cidade());
            pStmt.setObject(6, cli_clienteT.getCli_tx_estado());
            pStmt.setObject(7, cli_clienteT.getCli_tx_cep());
            pStmt.setObject(8, cli_clienteT.getCli_tx_cpf_cnpj());
            pStmt.setObject(9, cli_clienteT.getCli_tx_email());
            pStmt.setObject(10, cli_clienteT.getCli_tx_home_page());
            pStmt.setObject(11, cli_clienteT.getCli_tx_contato());
            pStmt.setObject(12, cli_clienteT.getCli_tx_status());
            pStmt.setObject(13, cli_clienteT.getLoj_nr_id());
            pStmt.setObject(14, cli_clienteT.getCli_nr_id());
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

    public void delete(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyfin.cli_cliente where  cli_nr_id=?";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    private List<Cli_clienteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_endereco(rs.getString("cli_tx_endereco"));
            cli_clienteT.setCli_tx_bairro(rs.getString("cli_tx_bairro"));
            cli_clienteT.setCli_tx_rg_inscricao(rs.getString("cli_tx_rg_inscricao"));
            cli_clienteT.setCli_tx_cidade(rs.getString("cli_tx_cidade"));
            cli_clienteT.setCli_tx_estado(rs.getString("cli_tx_estado"));
            cli_clienteT.setCli_tx_cep(rs.getInt("cli_tx_cep"));
            cli_clienteT.setCli_tx_cpf_cnpj(rs.getString("cli_tx_cpf_cnpj"));
            cli_clienteT.setCli_tx_email(rs.getString("cli_tx_email"));
            cli_clienteT.setCli_tx_home_page(rs.getString("cli_tx_home_page"));
            cli_clienteT.setCli_tx_contato(rs.getString("cli_tx_contato"));
            cli_clienteT.setCli_tx_status(rs.getString("cli_tx_status"));
            cli_clienteT.setLoj_nr_id(rs.getInt("loj_nr_id"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    public List<Cli_clienteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente ";
            pStmt = createPrepareStatment(sql);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cli_clienteT> getByPK(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  cli_nr_id=? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    public List<Cli_clienteT> getByCli_nr_id(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  cli_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    public List<Cli_clienteT> getByCli_tx_nome(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_nome) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_nome() + '%');
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

    public List<Cli_clienteT> getByCli_tx_endereco(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_endereco) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_endereco() + '%');
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

    public List<Cli_clienteT> getByCli_tx_bairro(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_bairro) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_bairro() + '%');
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

    public List<Cli_clienteT> getByCli_tx_rg_inscricao(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_rg_inscricao) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_rg_inscricao() + '%');
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

    public List<Cli_clienteT> getByCli_tx_cidade(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_cidade) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_cidade() + '%');
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

    public List<Cli_clienteT> getByCli_tx_estado(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_estado) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_estado() + '%');
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

    public List<Cli_clienteT> getByCli_tx_cep(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  cli_tx_cep = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_cep());
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

    public List<Cli_clienteT> getByCli_tx_cpf_cnpj(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_cpf_cnpj) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_cpf_cnpj() + '%');
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

    public List<Cli_clienteT> getByCli_tx_email(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_email) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_email() + '%');
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

    public List<Cli_clienteT> getByCli_tx_home_page(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_home_page) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_home_page() + '%');
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

    public List<Cli_clienteT> getByCli_tx_contato(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_contato) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_contato() + '%');
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

    public List<Cli_clienteT> getByCli_tx_status(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  Upper(cli_tx_status) like Upper(?) ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_status() + '%');
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

    public List<Cli_clienteT> getByLoj_nr_id(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where  loj_nr_id = ? ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, cli_clienteT.getLoj_nr_id());
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
    public List<Cli_clienteT> getByLoj_loja(int loj_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyfin.cli_cliente where loj_nr_id=?  ";
            pStmt = createPrepareStatment(sql);
            pStmt.setObject(1, loj_nr_id);
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
