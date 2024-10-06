package br.com.FilmesBanco.Main;

import br.com.FilmesBanco.Dao.FilmeDao;
import br.com.FilmesBanco.Model.Filme;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ViewFilme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilmeDao filmeDao = new FilmeDao();

        while (true) {
            try {


                System.out.println("Busca de Filmes");
                System.out.println("Digite um nome de um Filme, escreva o nome original (sem tradução).");
                System.out.println(" ");
                System.out.println("1 - Buscar um filme e salvar no banco de dados");
                System.out.println("2 - Apagar um filme salvo pelo ID");
                System.out.println("3 - Listar um filme salvo pelo ID");
                System.out.println("4 - Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        // Buscar filme por nome e salvar no banco de dados
                        System.out.println("Digite o nome do filme:");
                        String nomeFilme = scanner.nextLine();

                        try {
                            // Fazer a requisição para a API
                            String apiUrl = "http://www.omdbapi.com/?t=" + nomeFilme + "&apikey=f2d24bac";
                            URL url = new URL(apiUrl);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");
                            conn.connect();


                            // Verificar se a conexão foi bem-sucedida
                            int responseCode = conn.getResponseCode();
                            if (responseCode != 200) {
                                throw new RuntimeException("Erro na conexão com a API: " + responseCode);
                            } else {
                                System.out.println("Conexão com API de Filmes feita com sucesso !");
                            }

                            // Ler a resposta da API
                            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            StringBuilder response = new StringBuilder();
                            String line;
                            while ((line = br.readLine()) != null) {
                                response.append(line);
                            }
                            br.close();

                            // Converter a resposta para um JSONObject
                            JSONObject filmeJson = new JSONObject(response.toString());

                            if (filmeJson.getString("Response").equals("False")) {
                                System.out.println("Erro: " + filmeJson.getString("Error"));
                                continue; // Volta para o início do loop
                            }


                            // Criar o objeto Filme com base no JSON retornado
                            Filme filme = new Filme();
                            filme.setTitle(filmeJson.getString("Title"));
                            filme.setYear(filmeJson.getString("Year"));
                            filme.setRated(filmeJson.getString("Rated"));

                            filme.setReleased(filmeJson.getString("Released"));

                            filme.setRuntime(filmeJson.getString("Runtime"));
                            filme.setGenre(filmeJson.getString("Genre"));
                            filme.setDirector(filmeJson.getString("Director"));
                            filme.setWriter(filmeJson.getString("Writer"));
                            filme.setActors(filmeJson.getString("Actors"));
                            filme.setPlot(filmeJson.getString("Plot"));
                            filme.setLanguage(filmeJson.getString("Language"));
                            filme.setCountry(filmeJson.getString("Country"));
                            filme.setAwards(filmeJson.getString("Awards"));
                            filme.setPoster(filmeJson.getString("Poster"));
                            filme.setMetascore(filmeJson.optInt("Metascore", 0)); // Verifica se o campo existe
                            filme.setImdbRating(filmeJson.getString("imdbRating"));
                            filme.setImdbVotes(filmeJson.getString("imdbVotes"));
                            filme.setImdbID(filmeJson.getString("imdbID"));
                            filme.setType(filmeJson.getString("Type"));
                            filme.setDvd(filmeJson.getString("DVD"));
                            filme.setBoxOffice(filmeJson.getString("BoxOffice"));
                            filme.setProduction(filmeJson.getString("Production"));
                            filme.setWebsite(filmeJson.getString("Website"));
                            filme.setResponse(filmeJson.getString("Response"));

                            System.out.println("Filme buscado: ");

                            System.out.println("{");
                            System.out.println("  'Title': '" + filmeJson.getString("Title") + "',");
                            System.out.println("  'Year': '" + filmeJson.getString("Year") + "',");
                            System.out.println("  'Rated': '" + filmeJson.getString("Rated") + "',");
                            System.out.println("  'Released': '" + filmeJson.getString("Released") + "',");
                            System.out.println("  'Runtime': '" + filmeJson.getString("Runtime") + "',");
                            System.out.println("  'Genre': '" + filmeJson.getString("Genre") + "',");
                            System.out.println("  'Director': '" + filmeJson.getString("Director") + "',");
                            System.out.println("  'Writer': '" + filmeJson.getString("Writer") + "',");
                            System.out.println("  'Actors': '" + filmeJson.getString("Actors") + "',");
                            System.out.println("  'Plot': '" + filmeJson.getString("Plot") + "',");
                            System.out.println("  'Language': '" + filmeJson.getString("Language") + "',");
                            System.out.println("  'Country': '" + filmeJson.getString("Country") + "',");
                            System.out.println("  'Awards': '" + filmeJson.getString("Awards") + "',");
                            System.out.println("  'Poster': '" + filmeJson.getString("Poster") + "',");
                            System.out.println("  'Metascore': '" + filmeJson.optInt("Metascore", 0) + "',");
                            System.out.println("  'IMDb Rating': '" + filmeJson.getString("imdbRating") + "',");
                            System.out.println("  'IMDb Votes': '" + filmeJson.getString("imdbVotes") + "',");
                            System.out.println("  'IMDb ID': '" + filmeJson.getString("imdbID") + "',");
                            System.out.println("  'Type': '" + filmeJson.getString("Type") + "',");
                            System.out.println("  'DVD': '" + filmeJson.getString("DVD") + "',");
                            System.out.println("  'BoxOffice': '" + filmeJson.getString("BoxOffice") + "',");
                            System.out.println("  'Production': '" + filmeJson.getString("Production") + "',");
                            System.out.println("  'Website': '" + filmeJson.getString("Website") + "',");
                            System.out.println("  'Response': '" + filmeJson.getString("Response") + "'");
                            System.out.println("}");



                            // Salvar o filme no banco de dados
                            filmeDao.salvarFilme(filme);
                            System.out.println("Filme salvo com sucesso!");

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Erro ao salvar o filme.");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o ID do Filme que deseja remover do banco de dados: ");
                        int idFilmeRemover = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha que sobra após o nextInt()

                        System.out.println("Tem certeza que deseja remover do banco de dados? (sim/não)");
                        String resRemover = scanner.nextLine();

                        if (resRemover.equalsIgnoreCase("sim")) {
                            FilmeDao filmeDaoRemove = new FilmeDao();
                            try {
                                filmeDaoRemove.apagarFilme(idFilmeRemover);
                            } catch (Exception e) {
                                System.out.println("Erro ao tentar remover o filme.");
                            }
                        } else {
                            System.out.println("Operação cancelada.");
                        }

                        break;




                    case 3:

                        System.out.println("Digite o ID do filme que deseja listar:");
                        int idFilme = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        FilmeDao filmeDaoListar = new FilmeDao();

                        try {
                            Filme filmeListar = filmeDaoListar.listarFilmePorId(idFilme);

                            if (filmeListar != null) {
                                System.out.println("Informações do Filme:");
                                System.out.println("{");
                                System.out.println("  'Title': '" + filmeListar.getTitle() + "',");
                                System.out.println("  'Year': '" + filmeListar.getYear() + "',");
                                System.out.println("  'Rated': '" + filmeListar.getRated() + "',");
                                System.out.println("  'Released': '" + filmeListar.getReleased() + "',");
                                System.out.println("  'Runtime': '" + filmeListar.getRuntime() + "',");
                                System.out.println("  'Genre': '" + filmeListar.getGenre() + "',");
                                System.out.println("  'Director': '" + filmeListar.getDirector() + "',");
                                System.out.println("  'Writer': '" + filmeListar.getWriter() + "',");
                                System.out.println("  'Actors': '" + filmeListar.getActors() + "',");
                                System.out.println("  'Plot': '" + filmeListar.getPlot() + "',");
                                System.out.println("  'Language': '" + filmeListar.getLanguage() + "',");
                                System.out.println("  'Country': '" + filmeListar.getCountry() + "',");
                                System.out.println("  'Awards': '" + filmeListar.getAwards() + "',");
                                System.out.println("  'Poster': '" + filmeListar.getPoster() + "',");
                                System.out.println("  'Metascore': '" + filmeListar.getMetascore() + "',");
                                System.out.println("  'IMDb Rating': '" + filmeListar.getImdbRating() + "',");
                                System.out.println("  'IMDb Votes': '" + filmeListar.getImdbVotes() + "',");
                                System.out.println("  'IMDb ID': '" + filmeListar.getImdbID() + "',");
                                System.out.println("  'Type': '" + filmeListar.getType() + "',");
                                System.out.println("  'DVD': '" + filmeListar.getDvd() + "',");
                                System.out.println("  'BoxOffice': '" + filmeListar.getBoxOffice() + "',");
                                System.out.println("  'Production': '" + filmeListar.getProduction() + "',");
                                System.out.println("  'Website': '" + filmeListar.getWebsite() + "'");
                                System.out.println("}");
                            }

                        } catch (Exception e) {
                            System.out.println("Erro ao listar o filme.");
                            e.printStackTrace();
                        }
                        break;






                    case 4:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida, digite novamente.");





                }
            }catch (java.util.InputMismatchException e) {
                System.out.println("Erro: informações inválidas, digite novamente.");
                scanner.nextLine();
            }
        }
    }
}
