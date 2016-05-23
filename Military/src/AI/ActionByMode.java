/**
 * Created by Administrator on 2016/5/22.
 */
package AI;
import AI.Position;
import com.sun.imageio.plugins.common.I18NImpl;

public class ActionByMode {
    final int INFINITED = 888888888;
    public static int CoordinaryToIndex(int x, int y) {
        return 5 * x + y + 1;
    }
    public class ChessBoard {
        private Position []pos;
        public ChessBoard() {
            pos = new Position[61];
        }

        public int evaluate(int side) {
            int sum = 0;
            int sum2 = 0;
            for (int i = 1; i < 61; ++i) {
                if (pos[i].getRedorBlue() == side) {
                    if (pos[i].getName() == "地雷") {
                        sum += 5000;
                    } else if (pos[i].getName() == "炸弹") {
                        sum += 5000;
                    } else if (pos[i].getName() == "军旗") {
                        sum += INFINITED;
                    } else if (pos[i].getName() == "工兵") {
                        sum += 1000;
                    } else if (pos[i].getName() == "司令") {
                        sum += 50000;
                    } else if (pos[i].getName() == "军长") {
                        sum += 25000;
                    } else if (pos[i].getName() == "师长") {
                        sum += 5000;
                    } else if (pos[i].getName() == "旅长") {
                        sum += 2500;
                    } else if (pos[i].getName() == "团长") {
                        sum += 500;
                    } else if (pos[i].getName() == "营长") {
                        sum += 250;
                    } else if (pos[i].getName() == "连长") {
                        sum += 200;
                    } else if (pos[i].getName() == "排长") {
                        sum += 100;
                    } else {
                        sum += 0;
                    }
                } else {
                    if (pos[i].getName() == "地雷") {
                        sum2 += 5000;
                    } else if (pos[i].getName() == "炸弹") {
                        sum2 += 5000;
                    } else if (pos[i].getName() == "军旗") {
                        sum2 += INFINITED;
                    } else if (pos[i].getName() == "工兵") {
                        sum2 += 1000;
                    } else if (pos[i].getName() == "司令") {
                        sum2 += 50000;
                    } else if (pos[i].getName() == "军长") {
                        sum2 += 25000;
                    } else if (pos[i].getName() == "师长") {
                        sum2 += 5000;
                    } else if (pos[i].getName() == "旅长") {
                        sum2 += 2500;
                    } else if (pos[i].getName() == "团长") {
                        sum2 += 500;
                    } else if (pos[i].getName() == "营长") {
                        sum2 += 250;
                    } else if (pos[i].getName() == "连长") {
                        sum2 += 200;
                    } else if (pos[i].getName() == "排长") {
                        sum2 += 100;
                    } else {
                        sum2 += 0;
                    }
                }
            }
            return sum - sum2;
        }

        public boolean isEnded() {
            if (!allCanMove(1) || !allCanMove(0)) {
                return true;
            }
            boolean flag = false;
            for (int i = 1;i < 61; ++i) {
                if (pos[i].getRedorBlue() == 1) {
                    if (pos[i].getName() == "军旗") {
                        flag = true;
                        break;
                    }
                }
            }
            //一方无军旗
            if (!flag)
                return true;
            flag = false;
            for (int i = 1;i < 61; ++i) {
                if (pos[i].getRedorBlue() == 0) {
                    if (pos[i].getName() == "军旗") {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag)
                return true;
            return false;
        }

        private boolean allCanMove(int side) {
            for (int i = 1; i < 61; ++i) {
                if (pos[i].getIsAtive() == false) {
                    continue;
                } else if (pos[i].getRedorBlue() != side) {
                    continue;
                } else {
                    int x = pos[i].getPos_X();
                    int y = pos[i].getPos_Y();
                    if (x - 1 >= 0 && (pos[CoordinaryToIndex(x - 1, y)].getName() == null || pos[CoordinaryToIndex(x - 1, y)].getRedorBlue() == (1 - side))) {
                        return true;
                    }
                    if (x + 1 <= 11 && (pos[CoordinaryToIndex(x + 1, y)].getName() == null || pos[CoordinaryToIndex(x + 1,y)].getRedorBlue() == (1 - side))) {
                        return true;
                    }
                    if (y - 1 >= 0 && (pos[CoordinaryToIndex(x, y - 1)].getName() == null || pos[CoordinaryToIndex(x, y - 1)].getRedorBlue() == (1 - side))) {
                        return true;
                    }
                    if (y + 1 <= 4 && (pos[CoordinaryToIndex(x, y - 1)].getName() == null || pos[CoordinaryToIndex(x, y - 1)].getRedorBlue() == (1 - side))) {
                        return true;
                    }
                }
            }
            return false;
        }

        public ChessBoard nextMove(int from ,int to) {
            ChessBoard iniPos = new ChessBoard();
            for (int i = 1; i < 61; ++i) {
                iniPos.pos[i] = pos[i].Clone();
            }
            String name1 = iniPos.pos[from].getName();
            String name2 = iniPos.pos[to].getName();
            int redorblue1 = iniPos.pos[from].getRedorBlue();
            int redorblue2 = iniPos.pos[to].getRedorBlue();
            int casenum = fightResult(name1,name2);

            switch (casenum) {
                case 0:
                    iniPos.pos[from].setName(null);
                    iniPos.pos[to].setName(name1);
                    iniPos.pos[to].setRedorBlue(redorblue1);
                    break;
                case 1:
                    iniPos.pos[from].setName(null);
                    break;
                case 2:
                    iniPos.pos[from].setName(null);
                    iniPos.pos[to].setName(name1);
                    iniPos.pos[to].setRedorBlue(redorblue1);
                    break;
                case 3:
                    iniPos.pos[from].setName(null);
                    iniPos.pos[to].setName(null);
                    break;
                case 4:
                    iniPos.pos[from].setName(null);
                    iniPos.pos[to].setName(name1);
                    iniPos.pos[to].setRedorBlue(redorblue1);
                    break;
            }
            return iniPos;
        }

        private int fightResult(String str1, String str2) {
            if (str2 == null) {
                return 0;
            }
            if (str1 == "炸弹" || str2 == "炸弹" || str1 == str2) {
                return 3;
            }
            if (str2 == "军旗") {
                return 4;
            }
            if (comparePower(str1, str2)) {
                return 2;
            } else {
                return 1;
            }
        }

        private boolean comparePower(String str1, String str2) {
            String temp = str1;
            if (temp == "司令") {
                if (str2 == "军旗" || str2 == "军长" || str2 == "师长" || str2 == "旅长" || str2 == "团长" || str2 == "营长" || str2 == "连长" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "军长") {
                if (str2 == "军旗" || str2 == "师长" || str2 == "旅长" || str2 == "团长" || str2 == "营长" || str2 == "连长" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "师长") {
                if (str2 == "军旗" || str2 == "旅长" || str2 == "团长" || str2 == "营长" || str2 == "连长" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "旅长") {
                if (str2 == "军旗" || str2 == "团长" || str2 == "营长" || str2 == "连长" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "团长") {
                if (str2 == "军旗" || str2 == "营长" || str2 == "连长" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "营长") {
                if (str2 == "军旗" || str2 == "连长" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "连长") {
                if (str2 == "军旗" || str2 == "排长" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "排长") {
                if (str2 == "军旗" || str2 == "工兵") {
                    return true;
                } else {
                    return false;
                }
            } else if (temp == "工兵") {
                if (str2 == "军旗" || str2 == "地雷") {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

    }

    public class TotalValue {
        public int best;
        public int valueFrom;
        public int valueTo;
        public TotalValue() {
            best = 2 * -INFINITED;
            valueFrom = 0;
            valueTo = 0;
        }
    }

    public void ActionByMode(int mode) {
        if (mode == 0) {
            return;
        } else if(mode == 1) {
            ChessBoard initBoard = new ChessBoard();
            for (int i = 1;i < 61;++i) {

            }
        }
    }
}
