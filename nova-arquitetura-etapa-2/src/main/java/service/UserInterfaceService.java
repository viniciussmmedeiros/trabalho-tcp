package service;

/**
 * Funcionamento:
 * 1. A função principal main (UserInterfaceService) inicia a aba 'Generator' por padrão. A partir dela, ao clique
 * nas abas, será chamada a InstructionsInterfaceService e, se houver tempo, AboutInterfaceService.
 * 2. A partir do Generator, o usuário efetua o input e clica em 'Play Music', a partir disso os eventos são:
 *      2.1 - GenerateMusicResponse é chamada, itera sobre o input, utiliza o KeyMapper para conseguir o texto legível
 *      pelo JFugue e toca esse trecho com o player.play() (método do JFugue).
 *      2.2 - Dentro do KeyMapper é feito o mapeamento detalhado do input, trocando instrumentos midi, controlando o volume
 *      e oitavas, mas para o mapeamento simples ele utiliza o enum KeyLookup, obtendo as notas equivalentes aos caracteres
 *      de input.
 *
 * Os módulos neste caso foram definidos dessa forma, dividindo as responsabilidades para tornar fácil a manutenção e modificação
 * em caso de alterações na especificação.
 *
 * Ideias de melhoria:
 * 1. Ao invés de executar o áudio após cada caractere, é interessante processar todo o texto, armazenar o outuput e usar o player.play()
 * somente após finalizar todo o processamento, evitando assim delay entre as notas ocasionados por hardware.
 *
 **/

public class UserInterfaceService {

    public static void main(String[] args) {

        new GeneratorInterfaceService();
    }
}
