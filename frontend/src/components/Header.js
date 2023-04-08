import './Header.css';

function Header() {
  return (
    <header className="header-design">
      <div className="left-buttons">
        <a href="/">Hikmet Cakir</a>
      </div>
      <div className="right-buttons">
        <a href="/java">Java</a>
        <a href="/spring">Spring</a>
        <a href="/sql">SQL</a>
        <a href="/algorithm">Algorithm</a>
      </div>
    </header>
  );
}

export default Header;
