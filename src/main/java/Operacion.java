public enum Operacion {
        SUMA("+"),
        RESTA("-"),
        MULTIPLICACION("*"),
        DIVISION("/");

        private final String operador;

        Operacion(String operador) {
            this.operador = operador;
        }

        public String getOperador() {
            return operador;
        }
    }
