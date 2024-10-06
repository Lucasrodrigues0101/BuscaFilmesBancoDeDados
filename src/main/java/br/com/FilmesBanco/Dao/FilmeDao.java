package br.com.FilmesBanco.Dao;

import br.com.FilmesBanco.Factory.ConnectionFactory;
import br.com.FilmesBanco.Model.Filme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FilmeDao {


        public void salvarFilme(Filme filme) throws SQLException, ClassNotFoundException {
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(
                    "INSERT INTO T_FILMES (TITLE, YEAR, RATED, RELEASED, RUNTIME, GENRE, DIRECTOR, WRITER, ACTORS, PLOT, LANGUAGE, COUNTRY, AWARDS, POSTER, METASCORE, IMDB_RATING, IMDB_VOTES, IMDB_ID, TYPE, DVD, BOXOFFICE, PRODUCTION, WEBSITE, RESPONSE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            stmt.setString(1, filme.getTitle());
            stmt.setString(2, filme.getYear());
            stmt.setString(3, filme.getRated());
            stmt.setString(4, filme.getReleased());
            stmt.setString(5, filme.getRuntime());
            stmt.setString(6, filme.getGenre());
            stmt.setString(7, filme.getDirector());
            stmt.setString(8, filme.getWriter());
            stmt.setString(9, filme.getActors());
            stmt.setString(10, filme.getPlot());
            stmt.setString(11, filme.getLanguage());
            stmt.setString(12, filme.getCountry());
            stmt.setString(13, filme.getAwards());
            stmt.setString(14, filme.getPoster());
            stmt.setInt(15, filme.getMetascore());
            stmt.setString(16, filme.getImdbRating());
            stmt.setString(17, filme.getImdbVotes());
            stmt.setString(18, filme.getImdbID());
            stmt.setString(19, filme.getType());
            stmt.setString(20, filme.getDvd());
            stmt.setString(21, filme.getBoxOffice());
            stmt.setString(22, filme.getProduction());
            stmt.setString(23, filme.getWebsite());
            stmt.setString(24, filme.getResponse());

            stmt.executeUpdate();
            conexao.close();
        }

    public void apagarFilme(int id) throws SQLException, ClassNotFoundException {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_FILMES WHERE ID_FILME = ?");

        stm.setInt(1, id);
        //Executar o comando e recuperar a quantidade de linhas removidas
        int linhas = stm.executeUpdate();
        if (linhas == 0) {
            System.out.println("Filme não encontrado");
        }else{
            System.out.println("Filme removido com sucesso !");
        }
        stm.executeUpdate();
        conexao.close();
    }



    public Filme listarFilmePorId(int idFilme) throws SQLException, ClassNotFoundException {
        Connection conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM T_FILMES WHERE ID_FILME = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, idFilme);

        ResultSet rs = stm.executeQuery();
        Filme filme = null;

        if (rs.next()) {
            filme = new Filme();
            filme.setTitle(rs.getString("TITLE"));
            filme.setYear(rs.getString("YEAR"));
            filme.setRated(rs.getString("RATED"));
            filme.setReleased(rs.getString("RELEASED"));
            filme.setRuntime(rs.getString("RUNTIME"));
            filme.setGenre(rs.getString("GENRE"));
            filme.setDirector(rs.getString("DIRECTOR"));
            filme.setWriter(rs.getString("WRITER"));
            filme.setActors(rs.getString("ACTORS"));
            filme.setPlot(rs.getString("PLOT"));
            filme.setLanguage(rs.getString("LANGUAGE"));
            filme.setCountry(rs.getString("COUNTRY"));
            filme.setAwards(rs.getString("AWARDS"));
            filme.setPoster(rs.getString("POSTER"));
            filme.setMetascore(rs.getInt("METASCORE"));
            filme.setImdbRating(rs.getString("IMDB_RATING"));
            filme.setImdbVotes(rs.getString("IMDB_VOTES"));
            filme.setImdbID(rs.getString("IMDB_ID"));
            filme.setType(rs.getString("TYPE"));
            filme.setDvd(rs.getString("DVD"));
            filme.setBoxOffice(rs.getString("BOXOFFICE"));
            filme.setProduction(rs.getString("PRODUCTION"));
            filme.setWebsite(rs.getString("WEBSITE"));
        } else {
            System.out.println("Filme não encontrado.");
        }

        rs.close();
        stm.close();
        conexao.close();

        return filme;
    }



}

