package Game.CreateMap;

public class CreateMap {
    public static int[][] createMap(int mapIdx) {
        if (mapIdx == 1) {
            return new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                    {3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3},
                    {3, 0, 0, 0, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 3},
                    {3, 0, 1, 0, 1, 1, 3, 3, 3, 1, 1, 0, 1, 0, 3},
                    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
        } else if (mapIdx == 2) {
            return new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {3, 0, 0, 0, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 3},
                    {3, 0, 1, 0, 1, 1, 3, 3, 3, 1, 1, 0, 1, 0, 3},
                    {3, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
        } else if (mapIdx == 3) {
            return new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 1},
                    {3, 0, 1, 0, 1, 1, 3, 3, 3, 1, 1, 0, 1, 0, 3},
                    {3, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 3},
                    {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {3, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 3},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
        } else if (mapIdx == 4) {
            return new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 1},
                    {3, 0, 1, 0, 1, 1, 3, 3, 3, 1, 1, 0, 1, 0, 3},
                    {3, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 3},
                    {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {3, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 3},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
        } else if (mapIdx == 5){
            return new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 3, 3, 3, 1, 1, 0, 1, 0, 1},
                    {3, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 3},
                    {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                    {3, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 3},
                    {3, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 3},
                    {3, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 3},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };

        }
        return new int[][]{};
    }
}