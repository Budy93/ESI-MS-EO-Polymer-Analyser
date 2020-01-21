package de.daniel.brueggemann.tu.berlin.MSRechner;

public interface Filewriter {
    public boolean writtereport(String filename, Tensid tensid, Treffer treffer, AnalysenObjekt analysenObjekt);
}
