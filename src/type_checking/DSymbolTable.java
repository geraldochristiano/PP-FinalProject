package type_checking;

import java.util.ArrayList;
import java.util.List;

public class DSymbolTable implements SymbolTable {
    //Stores new variables declared in a scope, together with a boolean to store whether they have been initialized yet
    private List<List<Tuple<String, Boolean, Type>>> scopes;

    public DSymbolTable() {
        this.scopes = new ArrayList<>();
        openScope();
    }

    /**
     * Adds a next deeper scope level.
     */
    @Override
    public void openScope() {
        scopes.add(new ArrayList<>());
    }

    /**
     * Removes the deepest scope level.
     *
     * @throws RuntimeException if the table only contains the outer scope.
     */
    @Override
    public void closeScope() {
        if (scopes.size() > 1) {
            scopes.remove(scopes.size() - 1);
        } else {
            throw new RuntimeException("Cannot close outer scope");
        }
    }

    /**
     * Tries to declare a given identifier in the deepest scope level.
     *
     * @param id name of the new variable
     * @return <code>true</code> if the identifier was added,
     * <code>false</code> if it was already declared in this scope.
     */
    @Override
    public boolean add(Boolean decl, String id, Boolean init, Type type) {
        //If variable is not being declared here and it hasn't been declared before, return false
        if (!decl && !contains(id)) {
            return false;
        }

        //If already declared in the current scope and being declared here, return false
        if (decl && outer_contains(id)) {
            return false;
        }

        scopes.get(scopes.size() - 1).add(new Tuple<>(id, init, type));
        return true;
    }

    /**
     * Tests if a given identifier is in the scope of any declaration.
     *
     * @param id identifier to be checked
     * @return <code>true</code> if there is any enclosing scope in which
     * the identifier is declared; <code>false</code> otherwise.
     */
    @Override
    public boolean contains(String id) {
        for (int i = 0; i < scopes.size(); i++) {
            if (scope_contains(i, id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tests if a given identifier is in the given scope.
     *
     * @param scope to look in
     * @param id identifier to be checked
     * @return <code>true</code> if the identiefier is declared in the given scope; <code>false</code> otherwise.
     */
    private boolean scope_contains(int scope, String id) {
        for (Tuple<String, Boolean, Type> var : scopes.get(scope)) {
            if (var.fst().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tests if a given identifier is in the outer (current) scope.
     *
     * @param id identifier to be checked
     * @return <code>true</code> if the identiefier is declared in the outer scope; <code>false</code> otherwise.
     */
    private boolean outer_contains(String id) {
        return scope_contains(scopes.size() - 1, id);
    }

    /**
     * Get a tuple containing identifier, init state, and type of a variable
     *
     * @param id identifier of the variable
     * @return the tuple of the variable
     */
    private Tuple<String, Boolean, Type> getTuple(String id){
        for (int i = scopes.size() - 1; i >= 0; i--){
            if (scope_contains(i, id)){
                for (Tuple<String, Boolean, Type> var : scopes.get(i)){
                    if (var.fst().equals(id)){
                        return var;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Get the type of the variable last declared/defined.
     *
     * @param id identifier of the variable
     * @return the type of the variable from the latest declaration
     */
    public Type getType(String id){
        Tuple<String,Boolean,Type> tuple = getTuple(id);
        return tuple == null ? null : tuple.thrd();
    }

    /**
     * Check if a variable has been initialized.
     *
     * @param id identifier of the variable
     * @return <code>true</code> if the variable has been initialized, <code>false</code> otherwise
     */
    public boolean isInitialized(String id){
        Tuple<String,Boolean,Type> tuple = getTuple(id);
        return tuple != null && tuple.snd();
    }

    /**
     * Change initialization state of a variable.
     * This method does not care if the variable has been initialized or not.
     *
     * @param id identifier of the variable
     */
    public void initialize(String id) {
        Tuple<String, Boolean, Type> tuple = getTuple(id);
        if (tuple != null) tuple.snd(true);
    }

}
