class LiferayEventList extends HTMLElement {
    constructor() {
        super();
        this.events = [];
    }

    async connectedCallback() {
        this.innerHTML = `<div id="event-container">Chargement des événements...</div>`;
        await this.fetchEvents();
        this.render();
    }

    async fetchEvents() {
        try {
            // L'URL relative fonctionne car l'app est intégrée au portail
            const response = await fetch('/o/events-headless/v1.0/events?groupId=20117', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    // Utilisation du token de session native de Liferay
                    'x-csrf-token': Liferay.authToken 
                }
            });
            const data = await response.json();
            this.events = data.items || [];
        } catch (error) {
            console.error("Erreur lors de la récupération :", error);
            this.events = [];
        }
    }

    render() {
        const container = this.querySelector('#event-container');
        if (this.events.length === 0) {
            container.innerHTML = "<p>Ya pas d'événements.</p>";
            return;
        }

        container.innerHTML = `
            <div style="font-family: sans-serif; padding: 20px; border: 1px solid #ddd; border-radius: 8px;">
                <h2 style="color: #0053a0;">Liste des Événements</h2>
                <ul style="list-style: none; padding: 0;">
                    ${this.events.map(event => `
                        <li style="margin-bottom: 15px; border-bottom: 1px solid #eee; padding-bottom: 10px;">
                            <strong>${event.title}</strong><br/>
                            <small>📅 Du ${new Date(event.dateDebut).toLocaleDateString()} 
                            au ${new Date(event.dateFin).toLocaleDateString()}</small>
                        </li>
                    `).join('')}
                </ul>
            </div>
        `;
    }
}

// Enregistrement du Custom Element
if (!customElements.get('liferay-event-list')) {
    customElements.define('liferay-event-list', LiferayEventList);
}