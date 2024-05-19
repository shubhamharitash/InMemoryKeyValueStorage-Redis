import javafx.util.Pair;
import service.CommandService;
import service.impl.CommandServiceImpl;
import service.InMemoryService;
import util.FileWriterUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static contants.Commands.*;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        InMemoryService inMemoryService=new InMemoryService();
        CommandService commandService=new CommandServiceImpl();
        while (scanner.hasNext()) {
            String inpStr= scanner.nextLine();
            String[] inp = inpStr.trim().split(" ");
            try {
                switch (inp[0].toUpperCase()) {
                    case GET: {
                        System.out.println(inpStr);
                        FileWriterUtil.writeOutputToFile(commandService.get(inp[1]));
                        System.out.println("----------------------");
                    }
                    break;
                    case PUT: {
                        System.out.println(inpStr);
                        List<Pair<String, String>> listOfAttributePairs=new ArrayList<>();
                        for (int i=2;i<inp.length;i+=2)
                            listOfAttributePairs.add(new Pair<>(inp[i],inp[i+1]));
                        FileWriterUtil.writeOutputToFile(commandService.put(inp[1],listOfAttributePairs));
                        System.out.println("----------------------");
                    }
                    break;
                    case DELETE: {
                        System.out.println(inpStr);
                        commandService.delete(inp[1]);
                        System.out.println("----------------------");
                    }
                    break;
                    case KEYS: {
                        System.out.println(inpStr);
                        FileWriterUtil.writeOutputToFile(commandService.keys().toString());
                        System.out.println("----------------------");
                    }
                    break;
                    case SEARCH: {
                        System.out.println(inpStr);
                        FileWriterUtil.writeOutputToFile(commandService.search(inp[1],inp[2]).toString());
                        System.out.println("----------------------");
                    }
                    break;
                    case EXIT: {
                        System.out.println(inpStr);
                        commandService.exit();
                        System.out.println("----------------------");
                    }
                    break;
                    default: {
                        System.out.println("INVALID INPUT");
                    }
                }
            }
            catch (RuntimeException e){
                System.out.println(e);
            }
        }
    }
}
