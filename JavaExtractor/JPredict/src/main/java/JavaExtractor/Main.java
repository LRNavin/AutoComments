package JavaExtractor;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;


public class Main {
    public static void main(String args[]) throws Exception {
	System.out.println("runs");
	String code = "public class Class{\nprivate void assign(HashMap<String,DBIDs> labelMap,String label,DBIDRef id){\nif (labelMap.containsKey(label)) {\nDBIDs exist=labelMap.get(label);\nif (exist instanceof DBID) {\n ModifiableDBIDs n=DBIDUtil.newHashSet();\n n.add((DBID)exist);\nn.add(id);lnlabelMap.put(label,n);\n    }\n else {\n      assert (exist instanceof HashSetModifiableDBIDs);\n      assert (exist.size() > 1);\n      ((ModifiableDBIDs)exist).add(id);\n    }\n  }\n else {\n    labelMap.put(label,DBIDUtil.deref(id));\n  }\n}\n}";

	CompilationUnit parsed = JavaParser.parse(code);

	System.out.println(parsed);

    }
}
